package com.pracel.authorizationapp.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.pracel.authorizationapp.accounts.ui.AccountsScreen
import com.pracel.authorizationapp.home.ui.HomeScreen
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import com.pracel.authorizationapp.transactions.api.model.TransactionModel
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost

@Composable
fun MainNavHost(
    modifier: Modifier,
    navHostController: NavHostController,
    transactionsApi: TransactionsComponent
) {
    ScreenNavHost(
        modifier = modifier,
        startDestination = MainNavHostTab.Home.name,
        navController = navHostController
    ) {
        screen(MainNavHostTab.Home.name) {
            HomeScreen(transactionsApi)
        }
        screen(MainNavHostTab.Transactions.name) {
            transactionsApi.ComposableTransactionScreen()
        }
        screen(MainNavHostTab.Accounts.name) {
            AccountsScreen()
        }
    }
}


enum class MainNavHostTab {
    Home,
    Transactions,
    Accounts,
}