package com.pracel.authorizationapp.transaction.details.screen.model

import com.pracel.mvi.State

internal data class TransactionDetailsState(
    val id: Int? = null,
    val transactionType: String = "",
    val amount: String = "",
    val category: String = "",
    val source: String = "",
) : State
