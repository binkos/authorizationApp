package com.pracel.authorizationapp.home.api.domain

import com.pracel.authorizationapp.transactions.api.model.Transaction
import kotlinx.coroutines.flow.Flow

interface LastTransactionsUseCase {

    fun getLastTransactions(): Flow<List<Transaction>>
}