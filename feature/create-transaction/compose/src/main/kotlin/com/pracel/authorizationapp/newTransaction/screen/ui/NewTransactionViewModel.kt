package com.pracel.authorizationapp.newTransaction.screen.ui

import androidx.lifecycle.viewModelScope
import com.pracel.authorizationapp.newTransaction.screen.model.NewTransactionAction
import com.pracel.authorizationapp.newTransaction.screen.model.NewTransactionEvent
import com.pracel.authorizationapp.newTransaction.screen.model.NewTransactionState
import com.pracel.authorizationapp.transactions.api.model.NewTransaction
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import com.pracel.mvi.MVIViewModel
import kotlinx.coroutines.launch

internal class NewTransactionViewModel(
    private val transactionsRepository: TransactionsRepository
) : MVIViewModel<NewTransactionState, NewTransactionAction, NewTransactionEvent>(
    NewTransactionState()
) {

    override fun handleEvents(event: NewTransactionEvent) {
        viewModelScope.launch {
            when (event) {
                NewTransactionEvent.OnCreateButtonClicked -> {
                    val newTransaction = NewTransaction(
                        type = state.type,
                        amount = state.amount,
                        source = state.source,
                        category = state.name
                    )
                    transactionsRepository.addTransaction(newTransaction)
                }

                is NewTransactionEvent.OnTransactionNameChanged -> updateState {
                    copy(
                        name = event.name,
                        isCreateButtonEnabled = checkIsAllFieldsEntered(event.name, amount, source)
                    )
                }

                is NewTransactionEvent.OnTransactionAmountChanged -> updateState {
                    copy(
                        amount = event.amount.ifEmpty { "0" },
                        isCreateButtonEnabled = checkIsAllFieldsEntered(name, event.amount, source)
                    )
                }

                is NewTransactionEvent.OnTransactionSourceChanged -> updateState {
                    copy(
                        source = event.source,
                        isCreateButtonEnabled = checkIsAllFieldsEntered(name, amount, event.source)
                    )
                }

                is NewTransactionEvent.OnTransactionTypeChanged -> updateState { copy(type = event.type) }
            }
        }
    }

    private fun checkIsAllFieldsEntered(name: String, amount: String, source: String): Boolean {
        val isNameEntered = name.isNotEmpty()
        val isAmountCorrect = amount != "0"
        val isSourceEntered = source.isNotEmpty()

        return isNameEntered && isAmountCorrect && isSourceEntered
    }
}