package com.uladzislau_pravalenak.authorizationapp.signupFlow.root

import androidx.compose.runtime.Composable
import com.uladzislau_pravalenak.core.navigation.navHost.ScreenNavHost

@Composable
fun SignUpFlowNavHost() {

    ScreenNavHost(startDestination = "1") {
        screen("1"){}
        screen("2"){}
        screen("3"){}
    }
}