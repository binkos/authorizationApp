package com.pracel.authorizationapp.transactions.viewmodel

import androidx.lifecycle.viewModelScope
import com.pracel.authorizationapp.transactions.api.model.mapTransactionToUi
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import com.pracel.authorizationapp.transactions.model.TransactionsAction
import com.pracel.authorizationapp.transactions.model.TransactionsEvent
import com.pracel.authorizationapp.transactions.model.TransactionsState
import com.pracel.mvi.MVIViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class TransactionsScreenViewModel(
    transactionsRepository: TransactionsRepository
) : MVIViewModel<TransactionsState, TransactionsAction, TransactionsEvent>(TransactionsState()) {

    init {
        transactionsRepository
            .getAllTransactions()
            .map { it.map(::mapTransactionToUi) }
            .onEach { models -> updateState { copy(transactions = models) } }
            .launchIn(viewModelScope)
    }

    override fun handleEvents(event: TransactionsEvent) {

    }
}