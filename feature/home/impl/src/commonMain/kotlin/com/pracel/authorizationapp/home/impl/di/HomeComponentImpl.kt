package com.pracel.authorizationapp.home.impl.di

import com.pracel.authorizationapp.home.api.di.HomeComponent
import com.pracel.authorizationapp.home.api.di.HomeLastTransactionsModule

fun HomeComponent(dependencies: HomeComponentDependencies): HomeComponent {
    val homeLastTransactionsModule = HomeLastTransactionsModule(dependencies)

    return object : HomeComponent,
        HomeLastTransactionsModule by homeLastTransactionsModule {}
}