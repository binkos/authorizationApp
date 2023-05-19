package com.pracel.authorizationapp.transactions.api.repository

import com.pracel.authorizationapp.transactions.api.model.NewTransaction
import com.pracel.authorizationapp.transactions.api.model.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionsRepository {

    fun getAllTransactions(): Flow<List<Transaction>>

    suspend fun addTransaction(transaction: NewTransaction)

    suspend fun getTransactionById(id: Int): Transaction?
}