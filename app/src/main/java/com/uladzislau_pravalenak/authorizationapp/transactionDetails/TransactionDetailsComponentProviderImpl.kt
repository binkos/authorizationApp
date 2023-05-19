package com.uladzislau_pravalenak.authorizationapp.transactionDetails

import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsComponent
import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsComponentProvider
import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsUiModule
import com.pracel.authorizationapp.transaction.details.impl.di.TransactionDetailsUiModule

class TransactionDetailsComponentProviderImpl : TransactionDetailsComponentProvider {
//    private var _cached: TransactionDetailsComponent? = null

    override fun provideTransactionDetailsComponent(): TransactionDetailsComponent {
//        if (_cached != null) return _cached!!
        val uiModule = TransactionDetailsUiModule()
        return object : TransactionDetailsComponent, TransactionDetailsUiModule by uiModule {}

//        return _cached!!
    }
}