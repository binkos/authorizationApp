package com.pracel.authorizationapp.home.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.home.model.HomeState
import com.pracel.authorizationapp.home.viewmodel.HomeViewModel
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.api.model.TransactionModel

@Composable
fun HomeScreen() {
    val appContext = LocalContext.current.applicationContext
    val accountsComponent =
        appContext.getProvider<AccountComponentProvider>().provideAccountComponent()
    val transactionsComponent =
        appContext.getProvider<TransactionsComponentProvider>().provideTransactionsComponent()

    val viewModel: HomeViewModel =
        viewModel(initializer = { createViewModel(accountsComponent, transactionsComponent) })

    val state by viewModel.stateFlow.collectAsState()
    HomeScreenUi(state) { model ->
        transactionsComponent.RenderSingleTransaction(
            modifier = Modifier,
            transactionModel = model
        )
    }
}

@Composable
private fun HomeScreenUi(
    state: HomeState,
    transactionsUi: @Composable (transaction: TransactionModel) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        AppBar()
        MyAccounts(Modifier.fillMaxWidth(), state.accounts)
        LastTransactions(
            transactions = state.transactions,
            transactionsUi = transactionsUi
        )
    }
}

private fun createViewModel(
    accountsComponent: AccountsComponent,
    transactionsComponent: TransactionsComponent
): HomeViewModel {
    val accountRepository = accountsComponent.repository
    val transactionsRepository = transactionsComponent.repository

    return HomeViewModel(accountRepository, transactionsRepository)
}

fun <T> Context.getProvider(): T = this as T