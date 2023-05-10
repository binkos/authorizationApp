package com.pracel.authorizationapp.accounts.impl.di

import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import kotlinx.coroutines.Dispatchers

class AccountComponentProviderImpl(private val dispatchers: Dispatchers) : AccountComponentProvider {
    override fun provideAccountComponent(): AccountsComponent {
        val accountComponentDependencies = AccountComponentDependencies(dispatchers)

        return AccountsComponent(accountComponentDependencies)
    }
}