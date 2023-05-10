package com.pracel.authorizationapp.transactions.model

import com.pracel.authorizationapp.transactions.api.model.TransactionModel
import com.pracel.mvi.State

internal data class TransactionsState(
    val transactions: List<TransactionModel> = emptyList()
) : State