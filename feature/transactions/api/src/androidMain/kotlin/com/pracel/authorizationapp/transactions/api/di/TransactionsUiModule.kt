package com.pracel.authorizationapp.transactions.api.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pracel.authorizationapp.transactions.api.model.TransactionModel

actual interface TransactionsUiModule {

    @Composable
    fun ComposableSingleTransaction(modifier: Modifier, transactionModel: TransactionModel)

    @Composable
    fun ComposableTransactionScreen()
}