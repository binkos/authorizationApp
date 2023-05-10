package com.pracel.authorizationapp.transactions.impl.di

import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import kotlinx.coroutines.Dispatchers

class TransactionsComponentProviderImpl : TransactionsComponentProvider {
    private var cached: TransactionsComponent? = null

    override fun provideTransactionsComponent(): TransactionsComponent {
        if (cached != null) return cached!!
        val accountComponentDependencies = TransactionsComponentDependencies(Dispatchers)

        cached = TransactionsComponent(accountComponentDependencies)
        return cached!!
    }
}