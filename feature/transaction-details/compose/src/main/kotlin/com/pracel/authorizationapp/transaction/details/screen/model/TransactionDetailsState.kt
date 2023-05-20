package com.pracel.authorizationapp.transaction.details.screen.model

import com.pracel.authorizationapp.transactions.api.model.TransactionType
import com.pracel.mvi.State

internal data class TransactionDetailsState(
    val id: Int? = null,
    val transactionType: TransactionType = TransactionType.Income,
    val amount: String = "100$",
    val category: String = "",
    val source: String = "",
) : State
