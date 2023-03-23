package com.uladzislau_pravalenak.authorizationapp.signupFlow.root

import androidx.compose.runtime.Composable
import com.uladzislau_pravalenak.core.navigation.navHost.ScreenNavHost
import com.uladzislau_pravalenk.authorizationapp.core.routes.SignUpFlowRoutes

@Composable
fun SignUpFlowNavHost() {

    ScreenNavHost(startDestination = SignUpFlowRoutes.ENTER_DATA.name) {
        screen(SignUpFlowRoutes.ENTER_DATA.name){}
        screen(SignUpFlowRoutes.VERIFY_DATA.name){}
    }
}