package com.pracel.authorizationapp.transaction.details.screen.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pracel.authorizationapp.transaction.details.screen.model.TransactionDetailsEvent
import com.pracel.authorizationapp.transaction.details.screen.model.TransactionDetailsState
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow

@Composable
fun TransactionDetailScreen() {
    val navigator = LocalNavigator.currentOrThrow
    val viewModel: TransactionDetailsViewModel = viewModel(initializer = { createViewModel() })
    val state by viewModel.stateFlow.collectAsState()

    TransactionDetailScreenUi(state, viewModel::handleEvents, navigator::popBackStack)
}

@Composable
private fun TransactionDetailScreenUi(
    state: TransactionDetailsState,
    onEvent: (TransactionDetailsEvent) -> Unit,
    onBackPressed: () -> Unit
) {
    Column {
        TopAppBar(
            navigationIcon = {
                Icon(
                    modifier = Modifier.clickable(onClick = onBackPressed),
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = ""
                )
            },
            title = { Text(text = "Title Details") }
        )
        Text(modifier = Modifier.weight(1f), text = "Details")
        Button(onClick = { onEvent(TransactionDetailsEvent.OnAddButtonClicked) }) {
            Text(text = "Add Transaction")
        }
    }
}

private fun CreationExtras.createViewModel(): TransactionDetailsViewModel {
    val repository = (this[APPLICATION_KEY] as TransactionsComponentProvider).provideTransactionsComponent()
        .repository
    return TransactionDetailsViewModel(repository)
}