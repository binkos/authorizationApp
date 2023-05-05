package com.pracel.authorizationapp.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.home.model.Account
import com.pracel.authorizationapp.home.viewmodel.HomeViewModel
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = viewModel(initializer = ::createViewModel)

    val state by viewModel.stateFlow.collectAsState()
    HomeScreenUi(state.accounts)
}

@Composable
private fun HomeScreenUi(accounts: List<Account>) {
    Column(Modifier.fillMaxSize()) {
        AppBar()
        MyAccounts(Modifier.fillMaxWidth(), accounts)
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val accounts = listOf(
        Account(Icons.Filled.CreditCard, "$5 000", "Cash($)", Color.Gray),
        Account(Icons.Filled.AccountBalanceWallet, "₽3 200", "Credit Card(₽)", Color.Cyan),
        Account(Icons.Filled.Money, "$250", "Cash($)", Color.Gray),
    )
    AuthorizationAppTheme {
        Surface {
            HomeScreenUi(accounts)
        }
    }
}

private fun createViewModel(creationExtras: CreationExtras): HomeViewModel {
    val repository =
        (creationExtras[APPLICATION_KEY] as AccountComponentProvider)
            .provideAccountComponent()
            .repository

    return HomeViewModel(repository)
}