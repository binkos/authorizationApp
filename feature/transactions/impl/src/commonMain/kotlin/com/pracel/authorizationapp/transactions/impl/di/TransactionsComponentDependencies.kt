package com.pracel.authorizationapp.transactions.impl.di

import kotlinx.coroutines.Dispatchers

interface TransactionsComponentDependencies {
    val dispatchers: Dispatchers
}

fun TransactionsComponentDependencies(dispatchers: Dispatchers): TransactionsComponentDependencies =
    object : TransactionsComponentDependencies {
        override val dispatchers: Dispatchers
            get() = dispatchers
    }