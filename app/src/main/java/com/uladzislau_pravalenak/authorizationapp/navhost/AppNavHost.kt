package com.uladzislau_pravalenak.authorizationapp.navhost

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost
import com.uladzislau_pravalenak.authorizationapp.onboarding.OnboardingScreen
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.ui.SignInScreen
import com.uladzislau_pravalenak.authorizationapp.signUp.presentation.ui.SignUpScreen
import com.uladzislau_pravalenak.authorizationapp.splash.presentation.ui.SplashScreen
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Composable
fun AppNavHost() {
    ScreenNavHost(startDestination = AppFlowRoutes.SPLASH.name) {
        screen(AppFlowRoutes.SPLASH.name) { SplashScreen() }
        screen(AppFlowRoutes.ONBOARDING.name) { OnboardingScreen() }
        screen(AppFlowRoutes.SIGN_IN.name) { SignInScreen() }
        screen(
            "${AppFlowRoutes.SIGN_UP.name}/{navigateBack}",
            arguments = listOf(navArgument("navigateBack") { type = NavType.BoolType })
        ) {
            val navigateBack = it.arguments?.getBoolean("navigateBack", false) ?: false
            SignUpScreen(navigateBack)
        }
        screen(AppFlowRoutes.MAIN_FLOW.name) { }
    }
}