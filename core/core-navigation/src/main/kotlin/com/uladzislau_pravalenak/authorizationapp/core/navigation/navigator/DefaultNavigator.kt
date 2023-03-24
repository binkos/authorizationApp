package com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

val LocalNavigator = staticCompositionLocalOf<Navigator?> {
    null
}

data class DefaultNavigator(
    val navController: NavController,
    override val parentNavigator: Navigator?
) : Navigator {

    override fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit) {
        navController.navigate(route, builder)
    }

    override fun popBackStack() {
        navController.popBackStack()
    }

    override fun popBackStack(route: String, inclusive: Boolean, saveState: Boolean) {
        navController.popBackStack(route, inclusive, saveState)
    }
}