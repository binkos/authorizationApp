package com.pracel.authorizationapp.home.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pracel.authorizationapp.accounts.api.model.AccountModel
import com.pracel.authorizationapp.home.compose.R

@Composable
internal fun MyAccounts(
    modifier: Modifier = Modifier,
    accounts: List<AccountModel>,
    accountUi: @Composable (AccountModel) -> Unit
) {
    Column(modifier = modifier) {
        Header(R.string.my_accounts, modifier = Modifier.padding(vertical = 4.dp))
        AccountsBlock(accounts = accounts, accountUi = accountUi)
    }
}

@Composable
private fun AccountsBlock(
    modifier: Modifier = Modifier,
    accounts: List<AccountModel>,
    accountUi: @Composable (AccountModel) -> Unit
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier)
        accounts.forEach { model ->
            accountUi(model)
        }
        Spacer(modifier = Modifier)
    }
}

