package com.pracel.authorizationapp.newTransaction.screen.di

import androidx.compose.runtime.Composable
import com.pracel.authorizationapp.newTransaction.api.di.NewTransactionUiModule
import com.pracel.authorizationapp.newTransaction.screen.ui.NewTransactionScreen

class NewTransactionUiModuleImpl : NewTransactionUiModule {
    @Composable
    override fun ComposableNewTransactionScreen() = NewTransactionScreen()
}