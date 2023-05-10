package com.pracel.authorizationapp.transactions.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.model.TransactionsState
import com.pracel.authorizationapp.transactions.viewmodel.TransactionsScreenViewModel

@Composable
internal fun TransactionsScreen() {
    val viewModel: TransactionsScreenViewModel = viewModel(initializer = { createViewModel() })
    val state by viewModel.stateFlow.collectAsState()

    TransactionsScreenUi(state)
}

@Composable
internal fun TransactionsScreenUi(state: TransactionsState) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        items(state.transactions) {
            TransactionUi(transactionModel = it)
        }
    }
}

private fun CreationExtras.createViewModel(): TransactionsScreenViewModel {

    val repository = (this[APPLICATION_KEY] as TransactionsComponentProvider)
        .provideTransactionsComponent().repository

    return TransactionsScreenViewModel(repository)
}