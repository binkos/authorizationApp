package com.pracel.authorizationapp.transactions.impl.di

import com.pracel.authorizationapp.transactions.api.di.TransactionsModule
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
import com.pracel.authorizationapp.transactions.impl.repository.TransactionsRepositoryImpl

fun TransactionsModule(dependencies: TransactionsComponentDependencies): TransactionsModule {
    return object : TransactionsModule {
        override val repository: TransactionsRepository = TransactionsRepositoryImpl(dependencies.dispatchers)
    }
}