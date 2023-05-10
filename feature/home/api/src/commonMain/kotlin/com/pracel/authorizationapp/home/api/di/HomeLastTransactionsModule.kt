package com.pracel.authorizationapp.home.api.di

import com.pracel.authorizationapp.home.api.domain.LastTransactionsUseCase

interface HomeLastTransactionsModule {

    val lastTransactionsUseCase: LastTransactionsUseCase
}