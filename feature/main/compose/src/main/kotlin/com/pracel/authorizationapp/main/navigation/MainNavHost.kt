package com.pracel.authorizationapp.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.pracel.authorizationapp.accounts.ui.AccountsScreen
import com.pracel.authorizationapp.home.ui.HomeScreen
import com.pracel.authorizationapp.main.ui.tabs.transactions.TransactionsScreen
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost

@Composable
fun MainNavHost(
    modifier: Modifier,
    navHostController: NavHostController
) {

    ScreenNavHost(
        modifier = modifier,
        startDestination = MainNavHostTab.Home.name,
        navController = navHostController
    ) {
        screen(MainNavHostTab.Home.name) {
            HomeScreen()
        }
        screen(MainNavHostTab.Transactions.name) {
            TransactionsScreen()
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