package com.pracel.authorizationapp.accounts.impl.di

import com.pracel.authorizationapp.accounts.api.di.AccountModule
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent

//class AccountsComponentImpl(
//    private val accountModule: AccountModule,
//    private val dependencies: AccountComponentDependencies,
//) : AccountsComponent,
//    AccountModule by accountModule


fun AccountsComponent(
    dependencies: AccountComponentDependencies,
): AccountsComponent {
    val accountModule = AccountModule(dependencies)


    return object : AccountsComponent,
        AccountModule by accountModule {}
}