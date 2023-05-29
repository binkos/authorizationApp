package com.pracel.authorizationapp.accounts.impl.di

import com.pracel.authorizationapp.accounts.api.AccountsRepository
import com.pracel.authorizationapp.accounts.api.di.AccountModule
import com.pracel.authorizationapp.accounts.impl.AccountsRepositoryImpl

internal fun AccountModule(dependencies: AccountComponentDependencies): AccountModule {
    return object : AccountModule {
        override val repository: AccountsRepository = AccountsRepositoryImpl(dependencies.dispatchers)
    }
}