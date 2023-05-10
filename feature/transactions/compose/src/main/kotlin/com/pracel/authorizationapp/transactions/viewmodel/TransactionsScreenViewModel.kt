package com.pracel.authorizationapp.transactions.viewmodel

import androidx.lifecycle.viewModelScope
import com.pracel.authorizationapp.transactions.api.model.mapTransactionToUi
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import com.pracel.authorizationapp.transactions.model.TransactionsAction
import com.pracel.authorizationapp.transactions.model.TransactionsEvent
import com.pracel.authorizationapp.transactions.model.TransactionsState
import com.pracel.mvi.MVIViewModel
import kotlinx.coroutines.launch

internal class TransactionsScreenViewModel(
    private val transactionsRepository: TransactionsRepository
) : MVIViewModel<TransactionsState, TransactionsAction, TransactionsEvent>(TransactionsState()) {

    init {
        viewModelScope.launch {
            val models = transactionsRepository.getAllTransactions().map(::mapTransactionToUi)
            updateState { copy(transactions = models) }
        }
    }

    override fun handleEvents(event: TransactionsEvent) {

    }
}