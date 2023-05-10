package com.pracel.authorizationapp.home.ui

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Money
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pracel.authorizationapp.home.compose.R
import com.pracel.authorizationapp.home.model.Account

@Composable
internal fun MyAccounts(
    modifier: Modifier = Modifier,
    accounts: List<Account>
) {
    Column(modifier = modifier) {
        Header(R.string.my_accounts, modifier = Modifier.padding(vertical = 4.dp))
        AccountsBlock(accounts = accounts)
    }
}

@Composable
private fun AccountsBlock(
    modifier: Modifier = Modifier,
    accounts: List<Account>
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Spacer(modifier = Modifier)
        accounts.forEach {
            AccountUi(modifier = Modifier, account = it)
        }
        Spacer(modifier = Modifier)
    }
}

@Preview
@Composable
fun AllAccountsPreview() {
    val accounts = listOf(
        Account(Icons.Filled.CreditCard, "$5 000", "Cash($)", Color.Gray),
        Account(Icons.Filled.AccountBalanceWallet, "₽3 200", "Credit Card(₽)", Color.Cyan),
        Account(Icons.Filled.Money, "$250", "Cash($)", Color.Gray),
    )

    AuthorizationAppTheme {
        Surface {
            MyAccounts(accounts = accounts)
        }
    }
}

