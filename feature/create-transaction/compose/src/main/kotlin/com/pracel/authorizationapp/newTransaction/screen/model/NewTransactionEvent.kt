package com.pracel.authorizationapp.newTransaction.screen.model

import com.pracel.authorizationapp.transactions.api.model.TransactionType
import com.pracel.mvi.Event

sealed interface NewTransactionEvent : Event {
    data class OnTransactionTypeChanged(val type: TransactionType) : NewTransactionEvent
    data class OnTransactionNameChanged(val name: String) : NewTransactionEvent
    data class OnTransactionAmountChanged(val amount: String) : NewTransactionEvent
    data class OnTransactionSourceChanged(val source: String) : NewTransactionEvent
    object OnCreateButtonClicked : NewTransactionEvent
}