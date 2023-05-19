package com.pracel.authorizationapp.home.impl.domain

import com.pracel.authorizationapp.home.api.domain.LastTransactionsUseCase
import com.pracel.authorizationapp.transactions.api.model.Transaction
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LastTransactionsUseCaseImpl(
    private val transactionsRepository: TransactionsRepository
) : LastTransactionsUseCase {
    override fun getLastTransactions(): Flow<List<Transaction>> {
        return transactionsRepository
            .getAllTransactions()
            .map { it.take(5) }
    }
}