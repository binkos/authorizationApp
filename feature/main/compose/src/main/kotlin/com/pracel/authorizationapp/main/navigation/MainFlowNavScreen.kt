package com.pracel.authorizationapp.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.pracel.authorizationapp.main.ui.MainScreen
import com.pracel.authorizationapp.newTransaction.api.di.NewTransactionComponentProvider
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost

@Composable
fun MainFlowNavScreen() {
    val appContext = LocalContext.current.applicationContext
    val transactionDetailsApi = remember {
        (appContext as NewTransactionComponentProvider).provideNewTransactionComponent()
    }

    ScreenNavHost(startDestination = MainFlowNavHostDestinations.Main.name) {
        screen(MainFlowNavHostDestinations.Main.name) {
            MainScreen()
        }
//        screen(MainFlowNavHostDestinations.Settings.name) {
//
//        }
//
//        screen(MainFlowNavHostDestinations.TransactionDetails.name) {
//            transactionDetailsApi.ComposableTransactionDetails()
//        }
    }
}

internal enum class MainFlowNavHostDestinations {
    Main,
    CreateTransaction,
    Settings,
    TransactionDetails
}