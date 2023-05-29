package com.pracel.authorizationapp.newTransaction.api.di

import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository

interface NewTransactionComponent : NewTransactionUiModule {

    val allTransactionsRepository: TransactionsRepository
}