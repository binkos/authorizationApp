package com.uladzislau_pravalenak.authorizationapp.app

import android.app.Application
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountModule
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.accounts.api.di.AccountsUiModule
import com.pracel.authorizationapp.accounts.impl.di.AccountComponentDependencies
import com.pracel.authorizationapp.accounts.impl.di.AccountComponentProviderImpl
import com.pracel.authorizationapp.accounts.impl.di.AccountModule
import com.pracel.authorizationapp.accounts.impl.di.AccountsComponent
import com.pracel.authorizationapp.accounts.impl.di.AccountsUiModule
import com.pracel.authorizationapp.home.api.di.HomeComponentProvider
import com.pracel.authorizationapp.home.impl.di.HomeComponentProviderImpl
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.impl.di.TransactionsComponentProviderImpl
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers

@HiltAndroidApp
class AppApplication : Application(),
    TransactionsComponentProvider by TransactionsComponentProviderImpl(),
    HomeComponentProvider by HomeComponentProviderImpl(),
    AccountComponentProvider {

        //TODO: fix issue and use approach for Transactions and Home features
    override fun provideAccountComponent(): AccountsComponent {
        val dependencies = AccountComponentDependencies(Dispatchers)

//        return AccountsComponent(dependencies)
        val accountModule = AccountModule(dependencies)
        val accountsUiModule = AccountsUiModule()

        return object : AccountsComponent,
            AccountsUiModule by accountsUiModule,
            AccountModule by accountModule {}
    }
}