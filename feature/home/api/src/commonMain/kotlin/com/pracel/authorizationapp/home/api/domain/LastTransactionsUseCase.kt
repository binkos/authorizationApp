package com.pracel.authorizationapp.home.api.domain

import com.pracel.authorizationapp.transactions.api.model.Transaction

interface LastTransactionsUseCase {

    suspend fun getLastTransactions(): List<Transaction>
}