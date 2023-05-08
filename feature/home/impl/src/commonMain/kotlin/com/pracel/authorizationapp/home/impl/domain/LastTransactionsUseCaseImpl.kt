package com.pracel.authorizationapp.home.impl.domain

import com.pracel.authorizationapp.home.api.domain.LastTransactionsUseCase
import com.pracel.authorizationapp.transactions.api.model.Transaction
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository

class LastTransactionsUseCaseImpl(
    private val transactionsRepository: TransactionsRepository
) : LastTransactionsUseCase {
    override suspend fun getLastTransactions(): List<Transaction> {
        return transactionsRepository.getAllTransactions().take(15)
    }
}