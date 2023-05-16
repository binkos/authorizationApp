package com.pracel.authorizationapp.accounts.impl.di

import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import kotlinx.coroutines.Dispatchers

class AccountComponentProviderImpl() : AccountComponentProvider {
    override fun provideAccountComponent(): AccountsComponent {
        val accountComponentDependencies = AccountComponentDependencies(Dispatchers)

        return AccountsComponent(accountComponentDependencies)
    }
}