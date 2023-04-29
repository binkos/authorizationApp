package com.pracel.authorizationapp.main.ui.tabs.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pracel.authorizationapp.main.ui.tabs.accounts.AccountsScreen
import com.uladzislau_pravalenak.authorization.core.ui.theme.AuthorizationAppTheme

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "HOME")
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    AuthorizationAppTheme {
        Surface {
            HomeScreen()
        }
    }
}