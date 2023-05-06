package com.pracel.authorizationapp.transactions.impl.di

import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import kotlinx.coroutines.Dispatchers

class TransactionsComponentProviderImpl : TransactionsComponentProvider {

    override fun provideTransactionsComponent(): TransactionsComponent {
        val accountComponentDependencies = TransactionsComponentDependencies(Dispatchers)

        return TransactionsComponent(accountComponentDependencies)
    }
}