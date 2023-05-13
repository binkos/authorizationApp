package com.pracel.authorizationapp.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pracel.authorizationapp.accounts.api.di.AccountsComponent
import com.pracel.authorizationapp.home.ui.HomeScreen
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponent
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost

@Composable
fun MainNavHost(
    modifier: Modifier,
    navHostController: NavHostController,
    transactionsApi: TransactionsComponent,
    accountApi: AccountsComponent
) {
    ScreenNavHost(
        modifier = modifier,
        startDestination = MainNavHostTab.Home.name,
        navController = navHostController
    ) {
        screen(MainNavHostTab.Home.name) {
            HomeScreen(
                transactionUi = { model ->
                    transactionsApi.ComposableSingleTransaction(
                        modifier = Modifier,
                        transactionModel = model
                    )
                },
                accountUi = { model ->
                    accountApi.ComposableSingleAccount(modifier = Modifier, model = model)
                }
            )
        }
        screen(MainNavHostTab.Transactions.name) {
            transactionsApi.ComposableTransactionScreen()
        }
        screen(MainNavHostTab.Accounts.name) {
            accountApi.ComposableAccountsScreen()
        }
    }
}


enum class MainNavHostTab {
    Home,
    Transactions,
    Accounts,
}