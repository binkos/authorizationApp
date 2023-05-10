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
import com.pracel.authorizationapp.home.api.di.HomeComponentProvider
import com.pracel.authorizationapp.home.model.HomeState
import com.pracel.authorizationapp.home.viewmodel.HomeViewModel
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.model.TransactionModel

@Composable
fun HomeScreen(
    transactionsComponent: TransactionsComponent
) {
    val viewModel: HomeViewModel =
        viewModel(initializer = { createViewModel(transactionsComponent) })

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

private fun CreationExtras.createViewModel(
    transactionsComponent: TransactionsComponent
): HomeViewModel {
    val context = checkNotNull(this[APPLICATION_KEY])
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