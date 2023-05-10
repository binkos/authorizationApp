package com.pracel.authorizationapp.transactions.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pracel.authorizationapp.transactions.api.di.TransactionsUiModule
import com.pracel.authorizationapp.transactions.api.model.TransactionModel
import com.pracel.authorizationapp.transactions.ui.TransactionUi
import com.pracel.authorizationapp.transactions.ui.TransactionsScreen

fun TransactionsUiModule(): TransactionsUiModule {

    return object : TransactionsUiModule {

        @Composable
        override fun RenderSingleTransaction(
            modifier: Modifier,
            transactionModel: TransactionModel
        ) = TransactionUi(modifier = modifier, transactionModel = transactionModel)

        @Composable
        override fun ComposableTransactionScreen() = TransactionsScreen()
    }
}