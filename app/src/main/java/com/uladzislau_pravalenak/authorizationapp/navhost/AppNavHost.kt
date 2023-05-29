package com.uladzislau_pravalenak.authorizationapp.navhost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.pracel.authorizationapp.main.navigation.MainFlowNavScreen
import com.pracel.authorizationapp.main.ui.MainScreen
import com.pracel.authorizationapp.newTransaction.api.di.NewTransactionComponentProvider
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val appContext = LocalContext.current.applicationContext
    val transactionDetailsApi = remember {
        (appContext as NewTransactionComponentProvider).provideNewTransactionComponent()
    }
    ScreenNavHost(
        modifier = modifier,
        startDestination = AppFlowRoutes.MAIN_FLOW.name
    ) {
//        screen(AppFlowRoutes.SPLASH.name) { SplashScreen() }
//        screen(AppFlowRoutes.ONBOARDING.name) { OnboardingScreen() }
//        screen(AppFlowRoutes.SIGN_IN.name) {
//            SignInScreen()
//        }
//        configureSignUpScreen(navController)

        screen(AppFlowRoutes.MAIN_FLOW.name) {
//            MainFlowNavScreen()
            MainScreen()
        }

        screen(AppFlowRoutes.CREATE_TRANSACTION.name) {
            transactionDetailsApi.ComposableNewTransactionScreen()
        }
    }
}

//private fun NavBuilder.Default.configureSignUpScreen(navController: NavController) {
//    screen(AppFlowRoutes.SIGN_UP.name) {
//        val navigator = LocalNavigator.currentOrThrow
//
//        val onNavigate: () -> Unit = {
//            if (navController.backQueue.size == 2) {
//                navigator.navigate(AppFlowRoutes.SIGN_IN.name) {
//                    popUpTo(AppFlowRoutes.SIGN_UP.name) { inclusive = true }
//                }
//            } else {
//                navigator.popBackStack()
//            }
//        }
//        BackHandler(onBack = onNavigate)
//
//        SignUpScreen { onNavigate() }
//    }
//}