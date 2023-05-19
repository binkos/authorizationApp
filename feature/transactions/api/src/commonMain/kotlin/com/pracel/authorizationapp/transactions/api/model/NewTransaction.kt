package com.pracel.authorizationapp.transactions.api.model

data class NewTransaction(
    val type: TransactionType,
    val amount: String,
    val source: String,
    val category: String,
)