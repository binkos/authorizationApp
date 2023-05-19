package com.pracel.authorizationapp.transaction.details.screen.di

import androidx.compose.runtime.Composable
import com.pracel.authorizationapp.transaction.details.api.di.TransactionDetailsUiModule
import com.pracel.authorizationapp.transaction.details.screen.ui.TransactionDetailScreen

class TransactionDetailsUiModuleImpl : TransactionDetailsUiModule {
    @Composable
    override fun ComposableTransactionDetails() = TransactionDetailScreen()
}