package com.pracel.authorizationapp.transaction.details.screen.ui

import androidx.lifecycle.viewModelScope
import com.pracel.authorizationapp.transaction.details.screen.model.TransactionDetailsAction
import com.pracel.authorizationapp.transaction.details.screen.model.TransactionDetailsEvent
import com.pracel.authorizationapp.transaction.details.screen.model.TransactionDetailsState
import com.pracel.authorizationapp.transactions.api.model.NewTransaction
import com.pracel.authorizationapp.transactions.api.model.TransactionType
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import com.pracel.mvi.MVIViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

internal class TransactionDetailsViewModel(
    private val transactionsRepository: TransactionsRepository
) : MVIViewModel<TransactionDetailsState, TransactionDetailsAction, TransactionDetailsEvent>(
    TransactionDetailsState()
) {

    override fun handleEvents(event: TransactionDetailsEvent) {
        when (event) {
            is TransactionDetailsEvent.OnAddButtonClicked -> {
                viewModelScope.launch {
                    // TODO: change to adding transaction from state
                    transactionsRepository.addTransaction(
                        NewTransaction(TransactionType.Outcome, "100", "Cash", "games")
                    )
                }
            }
        }
    }
}