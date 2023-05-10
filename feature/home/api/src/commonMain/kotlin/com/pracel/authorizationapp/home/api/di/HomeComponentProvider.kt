package com.pracel.authorizationapp.home.api.di

import com.pracel.authorizationapp.transactions.api.di.TransactionsModule

interface HomeComponentProvider {
    fun provideHomeComponent(transactionsApi: TransactionsModule): HomeComponent
}