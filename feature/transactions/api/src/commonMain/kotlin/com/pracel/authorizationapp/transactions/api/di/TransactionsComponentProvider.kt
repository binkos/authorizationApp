package com.pracel.authorizationapp.transactions.api.di

import com.pracel.authorizationapp.core.di.ComponentProvider

interface TransactionsComponentProvider {
    fun provideTransactionsComponent(): TransactionsComponent
}