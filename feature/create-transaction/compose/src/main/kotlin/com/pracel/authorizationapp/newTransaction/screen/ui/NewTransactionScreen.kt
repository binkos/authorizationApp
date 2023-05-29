package com.pracel.authorizationapp.newTransaction.screen.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pracel.authorizationapp.newTransaction.api.di.NewTransactionComponentProvider
import com.pracel.authorizationapp.newTransaction.compose.R
import com.pracel.authorizationapp.newTransaction.screen.model.NewTransactionEvent
import com.pracel.authorizationapp.newTransaction.screen.model.NewTransactionState
import com.pracel.authorizationapp.transactions.api.model.TransactionType
import com.uladzislau_pravalenak.authorization.core.ui.input.TextInputField
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme

@Composable
fun NewTransactionScreen() {
    val viewModel: NewTransactionViewModel =
        viewModel(initializer = { createViewModel() })
    val state by viewModel.stateFlow.collectAsState()

    NewTransactionScreenUi(state = state, onEvent = viewModel::handleEvents)
}

@Composable
private fun NewTransactionScreenUi(
    state: NewTransactionState,
    onEvent: (NewTransactionEvent) -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .systemBarsPadding()
            .imePadding()
    ) {
        NewTransactionTypeRow(state.type)
        Spacer(modifier = Modifier.height(8.dp))
        TextInputField(
            modifier = Modifier.padding(top = 8.dp),
            title = stringResource(R.string.transaction_name),
            hint = "name",
            onValueChange = { onEvent(NewTransactionEvent.OnTransactionNameChanged(it)) },
            value = state.name
        )
        TextInputField(
            modifier = Modifier.padding(top = 8.dp),
            title = stringResource(R.string.amount),
            hint = "0,00",
            onValueChange = { onEvent(NewTransactionEvent.OnTransactionAmountChanged(it)) },
            value = state.amount
        )
        TextInputField(
            modifier = Modifier.padding(top = 8.dp),
            title = stringResource(R.string.source),
            hint = "Category",
            onValueChange = { onEvent(NewTransactionEvent.OnTransactionSourceChanged(it)) },
            value = state.source
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            onClick = { onEvent(NewTransactionEvent.OnCreateButtonClicked) },
            shape = RoundedCornerShape(16.dp),
            enabled = state.isCreateButtonEnabled
        ) {
            Text(
                text = stringResource(R.string.create_transaction),
                fontSize = 18.sp
            )
        }
    }
}

@Composable
private fun NewTransactionTypeRow(type: TransactionType) {
    Row(modifier = Modifier.height(36.dp)) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Expanse")
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Income")
        }
    }
}

private fun CreationExtras.createViewModel(): NewTransactionViewModel {
    val component = (this[APPLICATION_KEY] as NewTransactionComponentProvider)
        .provideNewTransactionComponent()

    return NewTransactionViewModel(component.allTransactionsRepository)
}

@Preview
@Composable
fun NewTransactionScreenUiPreview() {
    AuthorizationAppTheme {
        Surface {
            NewTransactionScreenUi(NewTransactionState()) {}
        }
    }
}