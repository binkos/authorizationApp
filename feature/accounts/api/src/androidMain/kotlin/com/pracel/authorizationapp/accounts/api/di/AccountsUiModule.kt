package com.pracel.authorizationapp.accounts.api.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pracel.authorizationapp.accounts.api.model.AccountModel

actual interface AccountsUiModule {

    @Composable
    fun ComposableSingleAccount(modifier: Modifier, model: AccountModel)

    @Composable
    fun ComposableAccountsScreen()
}