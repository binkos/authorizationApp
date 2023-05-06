package com.pracel.authorizationapp.transactions.impl.repository

import com.pracel.authorizationapp.transactions.api.model.Transaction
import com.pracel.authorizationapp.transactions.api.model.TransactionType
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

internal class TransactionsRepositoryImpl(private val dispatchers: Dispatchers) :
    TransactionsRepository {
    override suspend fun getAllTransactions(): List<Transaction> {
        return withContext(dispatchers.IO) {
            delay(2000L)
            listOf(
                Transaction(TransactionType.Income, "", "", ""),
                Transaction(TransactionType.Income, "", "", ""),
                Transaction(TransactionType.Income, "", "", ""),
                Transaction(TransactionType.Income, "", "", ""),
                Transaction(TransactionType.Income, "", "", ""),
            )
        }
    }
}