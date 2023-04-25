package com.uladzislau_pravalenak.authorizationapp.core.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navBuilder.DefaultNavBuilder
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navBuilder.NavBuilder
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.DefaultNavigator
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.Navigator

@Composable
fun ScreenNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    route: String? = null,
    builder: NavBuilder.Default.(NavController) -> Unit
) {
    CompositionLocalProvider(
        LocalNavigator provides rememberNavigator(navController),
    ) {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination,
            route = route,
        ) {
            DefaultNavBuilder(this).builder(navController)
        }
    }
}

@Composable
private fun rememberNavigator(navController: NavController): Navigator {
    val parent = LocalNavigator.current

    return remember(navController, parent) {
        DefaultNavigator(navController, parent)
    }
}