package com.pracel.authorizationapp.home.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.accounts.api.model.AccountModel
import com.pracel.authorizationapp.home.api.di.HomeComponentProvider
import com.pracel.authorizationapp.home.model.HomeState
import com.pracel.authorizationapp.home.viewmodel.HomeViewModel
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.api.model.TransactionModel

@Composable
fun HomeScreen(
    accountUi: @Composable (AccountModel) -> Unit,
    transactionUi: @Composable (TransactionModel) -> Unit,
) {
    val viewModel: HomeViewModel =
        //TODO write own wrapper to use ::createViewModel
        viewModel(initializer = { createViewModel() })

    val state by viewModel.stateFlow.collectAsState()
    HomeScreenUi(state, transactionUi, accountUi)
}

@Composable
private fun HomeScreenUi(
    state: HomeState,
    transactionsUi: @Composable (transaction: TransactionModel) -> Unit,
    accountUi: @Composable (AccountModel) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        AppBar()
        MyAccounts(Modifier.fillMaxWidth(), accounts = state.accounts, accountUi = accountUi)
        LastTransactions(
            transactions = state.transactions,
            transactionsUi = transactionsUi
        )
    }
}

private fun CreationExtras.createViewModel(): HomeViewModel {
    val context = checkNotNull(this[APPLICATION_KEY])
    val transactionsComponent =
        context.getProvider<TransactionsComponentProvider>().provideTransactionsComponent()

    val accountsComponent =
        context.getProvider<AccountComponentProvider>().provideAccountComponent()

    val homeComponent =
        context.getProvider<HomeComponentProvider>()
            .provideHomeComponent(transactionsComponent)

    val accountRepository = accountsComponent.repository
    val lastTransactionsUseCase = homeComponent.lastTransactionsUseCase

    return HomeViewModel(accountRepository, lastTransactionsUseCase)
}

fun <T> Context.getProvider(): T = this as T