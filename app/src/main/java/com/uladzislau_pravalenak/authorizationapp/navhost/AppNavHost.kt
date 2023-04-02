package com.uladzislau_pravalenak.authorizationapp.navhost

import androidx.compose.runtime.Composable
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost
import com.uladzislau_pravalenak.authorizationapp.onboarding.OnboardingScreen
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.ui.SignInScreen
import com.uladzislau_pravalenak.authorizationapp.signUpFlow.root.SignUpFlowNavHost
import com.uladzislau_pravalenak.authorizationapp.splash.presentation.ui.SplashScreen
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Composable
fun AppNavHost() {
    ScreenNavHost(startDestination = AppFlowRoutes.SPLASH.name) {
        screen(AppFlowRoutes.SPLASH.name) { SplashScreen() }
        screen(AppFlowRoutes.ONBOARDING.name) { OnboardingScreen() }
        screen(AppFlowRoutes.SIGN_IN.name) { SignInScreen() }
        screen(AppFlowRoutes.SIGN_UP_FLOW.name) { SignUpFlowNavHost() }
        screen(AppFlowRoutes.MAIN_FLOW.name) { }
    }
}