package com.pracel.authorizationapp.accounts.impl.di

import com.pracel.authorizationapp.accounts.api.di.AccountModule
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.accounts.api.di.AccountsUiModule

fun AccountsComponent(
    dependencies: AccountComponentDependencies,
): AccountsComponent {
    val accountModule = AccountModule(dependencies)
    val accountsUiModule = AccountsUiModule()

    return object : AccountsComponent,
        AccountsUiModule by accountsUiModule,
        AccountModule by accountModule {}
}