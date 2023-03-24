package com.uladzislau_pravalenak.authorizationapp.core.navigation.navBuilder

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink

sealed interface NavBuilder {

    interface Default : NavBuilder {

        fun NavBuilder.screen(
            route: String,
            arguments: List<NamedNavArgument> = emptyList(),
            deepLinks: List<NavDeepLink> = emptyList(),
            content: @Composable (NavBackStackEntry) -> Unit,
        )
    }

}