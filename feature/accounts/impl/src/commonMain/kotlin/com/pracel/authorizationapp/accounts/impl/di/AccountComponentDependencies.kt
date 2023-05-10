package com.pracel.authorizationapp.accounts.impl.di

import kotlinx.coroutines.Dispatchers

interface AccountComponentDependencies {
    val dispatchers: Dispatchers
}

fun AccountComponentDependencies(dispatchers: Dispatchers): AccountComponentDependencies =
    object : AccountComponentDependencies {
        override val dispatchers: Dispatchers
            get() = dispatchers
    }