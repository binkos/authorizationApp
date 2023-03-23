package com.uladzislau_pravalenak.core.navigation.navBuilder

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

class DefaultNavBuilder(
    private val navGraphBuilder: NavGraphBuilder,
) : NavBuilder.Default {

    override fun NavBuilder.screen(
        route: String,
        arguments: List<NamedNavArgument>,
        deepLinks: List<NavDeepLink>,
        content: @Composable (NavBackStackEntry) -> Unit
    ) {
        navGraphBuilder.composable(
            route = route,
            arguments = arguments,
            deepLinks = deepLinks,
            content = content
        )
    }
}