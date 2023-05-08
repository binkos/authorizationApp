package com.pracel.authorizationapp.home.impl.di

import com.pracel.authorizationapp.home.api.di.HomeLastTransactionsModule
import com.pracel.authorizationapp.home.api.domain.LastTransactionsUseCase
import com.pracel.authorizationapp.home.impl.domain.LastTransactionsUseCaseImpl

fun HomeLastTransactionsModule(dependencies: HomeComponentDependencies): HomeLastTransactionsModule {

    return object : HomeLastTransactionsModule {
        override val lastTransactionsUseCase: LastTransactionsUseCase
            get() = LastTransactionsUseCaseImpl(dependencies.repository)
    }
}