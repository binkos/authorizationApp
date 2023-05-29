package com.pracel.authorizationapp.newTransaction.screen.model

import com.pracel.authorizationapp.transactions.api.model.TransactionType
import com.pracel.mvi.State

data class NewTransactionState(
    val type: TransactionType = TransactionType.Income,
    val name: String = "Coffee",
    val amount: String = "0",
    val source: String = "Cash",
    val isCreateButtonEnabled: Boolean = true
) : State