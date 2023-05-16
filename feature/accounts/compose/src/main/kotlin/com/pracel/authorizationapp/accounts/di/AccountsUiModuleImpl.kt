package com.pracel.authorizationapp.accounts.di

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pracel.authorizationapp.accounts.api.di.AccountsUiModule
import com.pracel.authorizationapp.accounts.api.model.AccountModel
import com.pracel.authorizationapp.accounts.ui.AccountUi
import com.pracel.authorizationapp.accounts.ui.AccountsScreen

fun AccountsUiModule(): AccountsUiModule {

    return object : AccountsUiModule {

        @Composable
        override fun ComposableSingleAccount(modifier: Modifier, model: AccountModel) =
            AccountUi(modifier, model)

        @Composable
        override fun ComposableAccountsScreen() = AccountsScreen()
    }
}