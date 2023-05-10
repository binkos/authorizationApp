package com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator

import androidx.navigation.NavOptionsBuilder

interface Navigator {
    val parentNavigator: Navigator?

    fun navigate(
        route: String,
        builder: NavOptionsBuilder.() -> Unit = {}
    )

    fun popBackStack()

    fun popBackStack(
        route: String,
        inclusive: Boolean = false,
        saveState: Boolean = false
    )
}