package com.uladzislau_pravalenak.authorizationapp.app.account

import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.accounts.impl.di.AccountComponentDependencies
import com.pracel.authorizationapp.accounts.impl.di.AccountsComponent
import kotlinx.coroutines.Dispatchers

class AccountComponentProviderImpl : AccountComponentProvider {

    override fun provideAccountComponent(): AccountsComponent {
        val accountComponentDependencies = AccountComponentDependencies(Dispatchers)

        return AccountsComponent(accountComponentDependencies)
    }
}