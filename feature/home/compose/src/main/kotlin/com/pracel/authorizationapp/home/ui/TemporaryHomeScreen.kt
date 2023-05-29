package com.pracel.authorizationapp.home.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pracel.authorizationapp.home.api.di.HomeComponentProvider
import com.pracel.authorizationapp.home.model.HomeState
import com.pracel.authorizationapp.home.viewmodel.HomeViewModel
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.api.model.TransactionModel
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Composable
fun TemporaryHomeScreen() {
    val navigator = LocalNavigator.currentOrThrow
    val context = LocalContext.current
    val transactionsApi = remember {
        context.applicationContext
            .getProvider<TransactionsComponentProvider>().provideTransactionsComponent()
    }
//    val newTransactionApi = remember {
//        context.applicationContext
//            .getProvider<NewTransactionComponentProvider>().provideNewTransactionComponent()
//    }

    val viewModel: HomeViewModel =
        //TODO write own wrapper to use ::createViewModel
        viewModel(initializer = { createViewModel(transactionsApi) })

    val state by viewModel.stateFlow.collectAsState()

    TemporaryHomeScreenUi(
        state = state,
        transactionUi = { model -> transactionsApi.ComposableSingleTransaction(Modifier, model) },
        onAddButtonClicked = { navigator.navigate(AppFlowRoutes.CREATE_TRANSACTION.name) }
    )
}

@Composable
private fun TemporaryHomeScreenUi(
    state: HomeState,
    transactionUi: @Composable (TransactionModel) -> Unit,
    onAddButtonClicked: () -> Unit
) {
    Column(
        Modifier
            .systemBarsPadding()
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, bottom = 4.dp, top = 8.dp),
    ) {
        MyBudget("0,00$")
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MonthlyExpanses(amount = "270.00$", modifier = Modifier.weight(1f))
            MonthlyIncomes(amount = "270.00$", modifier = Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(8.dp))

        if (state.transactions.isNotEmpty()) {
            LastTransactions(transactions = state.transactions, transactionsUi = transactionUi)
        }
        Spacer(modifier = Modifier.weight(1f))

        AddTransactionButton(
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            onClick = onAddButtonClicked
        )
    }
}

@Composable
private fun MyBudget(
    amount: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Gray)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = "My Budget")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = amount)
    }
}

@Composable
private fun MonthlyExpanses(
    amount: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
            .padding(8.dp)
    ) {
        Text(text = "My Expanses")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = amount)
    }
}

@Composable
private fun MonthlyIncomes(
    amount: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .border(BorderStroke(1.dp, Color.Gray), RoundedCornerShape(8.dp))
            .padding(8.dp)
    ) {
        Text(text = "My Incomes")
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = amount)
    }
}

@Composable
private fun AddTransactionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = "Add Transaction",
            fontSize = 18.sp
        )
    }
}

private fun CreationExtras.createViewModel(transactionApi: TransactionsComponent): HomeViewModel {
    val context = checkNotNull(this[APPLICATION_KEY])

//    val accountsComponent =
//        context.getProvider<AccountComponentProvider>().provideAccountComponent()

    val homeComponent =
        context.getProvider<HomeComponentProvider>()
            .provideHomeComponent(transactionApi)

//    val accountRepository = accountsComponent.repository
    val lastTransactionsUseCase = homeComponent.lastTransactionsUseCase

    return HomeViewModel(/*accountRepository,*/ lastTransactionsUseCase)
}

@Preview
@Composable
fun TemporaryMainScreenPreview() {
    AuthorizationAppTheme {
        Surface {
            TemporaryHomeScreenUi(HomeState(), {}) {}
        }
    }
}