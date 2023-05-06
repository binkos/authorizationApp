package com.pracel.authorizationapp.transactions.api.di

import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository

interface TransactionsModule {
    val repository: TransactionsRepository
}