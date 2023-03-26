package com.uladzislau_pravalenak.authorizationapp.signUpFlow.root

import androidx.compose.runtime.Composable
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost
import com.uladzislau_pravalenak.authorizationapp.signUpFlow.enterData.EnterDataScreen
import com.uladzislau_pravalenk.authorizationapp.core.routes.SignUpFlowRoutes

@Composable
fun SignUpFlowNavHost() {

    ScreenNavHost(startDestination = SignUpFlowRoutes.ENTER_DATA.name) {
        screen(SignUpFlowRoutes.ENTER_DATA.name){ EnterDataScreen() }
        screen(SignUpFlowRoutes.VERIFY_DATA.name){}
    }
}