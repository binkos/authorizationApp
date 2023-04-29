package com.pracel.authorizationapp.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.pracel.authorizationapp.home.ui.model.Account
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme

@Composable
fun HomeScreen() {
    val accounts = emptyList<Account>()

    HomeScreenUi(accounts)
}

@Composable
fun HomeScreenUi(accounts: List<Account>) {
    Column {
        AppBar()
        MyAccounts(accounts)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
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