package com.pracel.authorizationapp.transactions.impl.di

import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.di.TransactionsModule
import com.pracel.authorizationapp.transactions.api.di.TransactionsUiModule

fun TransactionsComponent(
    dependencies: TransactionsComponentDependencies,
): TransactionsComponent {
    val transactionsModule = TransactionsModule(dependencies)
    val transactionsUiModule = TransactionsUiModule()

    return object : TransactionsComponent,
        TransactionsModule by transactionsModule,
        TransactionsUiModule by transactionsUiModule {}
}