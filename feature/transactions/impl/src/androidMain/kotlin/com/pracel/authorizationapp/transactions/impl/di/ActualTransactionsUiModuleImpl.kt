package com.pracel.authorizationapp.transactions.impl.di

import com.pracel.authorizationapp.transactions.api.di.TransactionsUiModule

actual fun TransactionsUiModule(): TransactionsUiModule =
    com.pracel.authorizationapp.transactions.di.TransactionsUiModule()
