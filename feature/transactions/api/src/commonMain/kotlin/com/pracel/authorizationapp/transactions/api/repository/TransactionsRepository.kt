package com.pracel.authorizationapp.transactions.api.repository

import com.pracel.authorizationapp.transactions.api.model.Transaction

interface TransactionsRepository {

    suspend fun getAllTransactions(): List<Transaction>
}