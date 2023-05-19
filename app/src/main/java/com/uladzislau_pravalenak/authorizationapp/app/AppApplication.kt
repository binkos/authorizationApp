package com.uladzislau_pravalenak.authorizationapp.app

import android.app.Application
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountModule
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.accounts.api.di.AccountsUiModule
import com.pracel.authorizationapp.accounts.impl.di.AccountComponentDependencies
import com.pracel.authorizationapp.accounts.impl.di.AccountModule
import com.pracel.authorizationapp.accounts.impl.di.AccountsUiModule
import com.pracel.authorizationapp.analytics.api.di.AnalyticsComponent
import com.pracel.authorizationapp.analytics.api.di.AnalyticsComponentProvider
import com.pracel.authorizationapp.analytics.api.di.AnalyticsUiModule
import com.pracel.authorizationapp.analytics.impl.di.AnalyticsUiModuleImpl
import com.pracel.authorizationapp.home.api.di.HomeComponentProvider
import com.pracel.authorizationapp.home.impl.di.HomeComponentProviderImpl
import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsComponent
import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsComponentProvider
import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsUiModule
import com.pracel.authorizationapp.transaction.details.impl.di.TransactionDetailsUiModule
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.impl.di.TransactionsComponentProviderImpl
import com.uladzislau_pravalenak.authorizationapp.transactionDetails.TransactionDetailsComponentProviderImpl
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.Dispatchers

@HiltAndroidApp
class AppApplication : Application(),
    TransactionsComponentProvider by TransactionsComponentProviderImpl(),
    HomeComponentProvider by HomeComponentProviderImpl(),
    TransactionDetailsComponentProvider by TransactionDetailsComponentProviderImpl(),
    AccountComponentProvider,
    AnalyticsComponentProvider {

    //  TODO: fix issue and use approach for Transactions and Home features
    override fun provideAccountComponent(): AccountsComponent {
        val dependencies = AccountComponentDependencies(Dispatchers)

//        return AccountsComponent(dependencies)
        val accountModule = AccountModule(dependencies)
        val accountsUiModule = AccountsUiModule()

        return object : AccountsComponent,
            AccountsUiModule by accountsUiModule,
            AccountModule by accountModule {}
    }

    override fun provideAnalyticsComponent(): AnalyticsComponent {
        val analyticsUiModule = AnalyticsUiModuleImpl()

        return object : AnalyticsComponent,
            AnalyticsUiModule by analyticsUiModule {}
    }
}