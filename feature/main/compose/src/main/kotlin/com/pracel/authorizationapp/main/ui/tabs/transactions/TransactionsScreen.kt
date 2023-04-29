package com.pracel.authorizationapp.main.ui.tabs.transactions

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme

@Composable
fun TransactionsScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "TRANSACTIONS")
    }
}

@Preview()
@Composable
fun TransactionsScreenPreview() {
    AuthorizationAppTheme {
        Surface {
            TransactionsScreen()
        }
    }
}