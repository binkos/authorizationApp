package com.uladzislau_pravalenak.authorizationapp.app

import android.app.Application
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.accounts.impl.di.AccountComponentDependencies
import com.pracel.authorizationapp.accounts.impl.di.AccountsComponent
import com.pracel.authorizationapp.analytics.api.di.AnalyticsComponent
import com.pracel.authorizationapp.analytics.api.di.AnalyticsComponentProvider
import com.pracel.authorizationapp.analytics.api.di.AnalyticsUiModule
import com.pracel.authorizationapp.analytics.impl.di.AnalyticsUiModuleImpl
import com.pracel.authorizationapp.home.api.di.HomeComponentProvider
import com.pracel.authorizationapp.home.impl.di.HomeComponentProviderImpl
import com.pracel.authorizationapp.newTransaction.api.di.NewTransactionComponent
import com.pracel.authorizationapp.newTransaction.api.di.NewTransactionComponentProvider
import com.pracel.authorizationapp.newTransaction.api.di.NewTransactionUiModule
import com.pracel.authorizationapp.newTransaction.impl.di.NewTransactionUiModule
import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsComponentProvider
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.api.repository.TransactionsRepository
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
    AnalyticsComponentProvider,
    NewTransactionComponentProvider {

    //  TODO: fix issue and use approach for Transactions and Home features
    override fun provideAccountComponent(): AccountsComponent {
        val accountComponentDependencies = AccountComponentDependencies(Dispatchers)
        return AccountsComponent(accountComponentDependencies)
    }

    override fun provideAnalyticsComponent(): AnalyticsComponent {
        val analyticsUiModule = AnalyticsUiModuleImpl()

        return object : AnalyticsComponent,
            AnalyticsUiModule by analyticsUiModule {}
    }

    override fun provideNewTransactionComponent(): NewTransactionComponent {
        // TODO: When will be migrated to persistence storage we can create here TransactionsModule
        val transactionComponent = provideTransactionsComponent()

        return object : NewTransactionComponent,
            NewTransactionUiModule by NewTransactionUiModule() {
            override val allTransactionsRepository: TransactionsRepository
                get() = transactionComponent.repository
        }
    }

    // experimental solution that create singleton
    override val provideNewTransactionComponent: NewTransactionComponent by lazy {
        val transactionComponent = provideTransactionsComponent()

        object : NewTransactionComponent,
            NewTransactionUiModule by NewTransactionUiModule() {
            override val allTransactionsRepository: TransactionsRepository
                get() = transactionComponent.repository
        }
    }
}