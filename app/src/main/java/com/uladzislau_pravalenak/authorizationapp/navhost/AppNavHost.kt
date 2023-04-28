package com.uladzislau_pravalenak.authorizationapp.navhost

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.core.util.Consumer
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.pracel.authorizationapp.main.navigation.MainFlowNavScreen
import com.pracel.authorizationapp.main.ui.MainScreen
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navBuilder.NavBuilder
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenak.authorizationapp.onboarding.OnboardingScreen
import com.uladzislau_pravalenak.authorizationapp.signIn.presentation.ui.SignInScreen
import com.uladzislau_pravalenak.authorizationapp.signUp.presentation.ui.SignUpScreen
import com.uladzislau_pravalenak.authorizationapp.splash.presentation.ui.SplashScreen
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Composable
fun AppNavHost() {
    ScreenNavHost(startDestination = AppFlowRoutes.SPLASH.name) { navController ->
        screen(AppFlowRoutes.SPLASH.name) { SplashScreen() }
        screen(AppFlowRoutes.ONBOARDING.name) { OnboardingScreen() }
        screen(AppFlowRoutes.SIGN_IN.name) {
            SignInScreen()
        }
        configureSignUpScreen(backStackSize = navController.backQueue.size)

        screen(AppFlowRoutes.MAIN_FLOW.name) {
            MainFlowNavScreen()
        }
    }
}

private fun NavBuilder.Default.configureSignUpScreen(backStackSize: Int) {
    screen(AppFlowRoutes.SIGN_UP.name) {
        val navigator = LocalNavigator.currentOrThrow

        val onNavigate: () -> Unit = {
            if (backStackSize == 2) {
                navigator.navigate(AppFlowRoutes.SIGN_IN.name) {
                    popUpTo(AppFlowRoutes.SIGN_UP.name) { inclusive = true }
                }
            } else {
                navigator.popBackStack()
            }
        }
        BackHandler {
            onNavigate()
        }

        SignUpScreen { onNavigate() }
    }
}