package com.pracel.authorizationapp.main.navigation

import androidx.compose.runtime.Composable
import com.pracel.authorizationapp.main.ui.MainScreen
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost.ScreenNavHost

@Composable
fun MainFlowNavScreen() {
    ScreenNavHost(startDestination = MainFlowNavHostDestinations.Main.name) {
        screen(MainFlowNavHostDestinations.Main.name) {
            MainScreen()
        }
        screen(MainFlowNavHostDestinations.Settings.name) {

        }
    }
}

internal enum class MainFlowNavHostDestinations {
    Main,
    Settings,
}