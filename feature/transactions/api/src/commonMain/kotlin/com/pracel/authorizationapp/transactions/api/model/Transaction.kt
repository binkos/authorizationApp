package com.pracel.authorizationapp.transactions.api.model

data class Transaction(
    val type: TransactionType,
    val amount: String,
    val source: String,
    val category: String,
)

