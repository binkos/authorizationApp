package com.pracel.authorizationapp.home.impl.di

import com.pracel.authorizationapp.home.api.di.HomeComponent
import com.pracel.authorizationapp.home.api.di.HomeComponentProvider
import com.pracel.authorizationapp.transactions.api.di.TransactionsModule

class HomeComponentProviderImpl : HomeComponentProvider {
    override fun provideHomeComponent(transactionsApi: TransactionsModule): HomeComponent {
        val dependencies = HomeComponentDependencies(transactionsApi.repository)

        return HomeComponent(dependencies)
    }
}