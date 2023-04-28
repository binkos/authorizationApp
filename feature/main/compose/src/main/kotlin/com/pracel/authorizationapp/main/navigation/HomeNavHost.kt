package com.pracel.authorizationapp.main.navigation

import androidx.compose.runtime.Composable
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost

@Composable
fun HomeNavHost() {
    ScreenNavHost(startDestination = MainNavHostDestinations.Home.name) {
        screen(MainNavHostDestinations.Home.name) {

        }
        screen(MainNavHostDestinations.Transactions.name) {

        }
        screen(MainNavHostDestinations.Accounts.name) {

        }
    }
}


enum class MainNavHostDestinations {
    Home,
    Transactions,
    Accounts,
}