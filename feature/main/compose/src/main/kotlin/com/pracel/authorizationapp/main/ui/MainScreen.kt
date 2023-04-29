package com.pracel.authorizationapp.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.pracel.authorizationapp.main.navigation.MainNavHost
import com.pracel.authorizationapp.main.navigation.MainNavHostTab

@Composable
fun MainScreen() {
    val navigationController = rememberNavController()
    val navBackStackEntry by navigationController.currentBackStackEntryAsState()
    val currentTab = navBackStackEntry?.destination?.route?.let { MainNavHostTab.valueOf(it) }

    val onNavigate: (MainNavHostTab) -> Unit = remember {
        { tab ->
            navigationController.navigate(tab.name) {
                navigationController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) { saveState = true }
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    Scaffold(
        bottomBar = { BottomBar(currentTab, onNavigate) }
    ) {
        MainNavHost(
            modifier = Modifier.padding(it.calculateBottomPadding()),
            navHostController = navigationController
        )
    }
}

@Composable
private fun BottomBar(
    openedTab: MainNavHostTab?,
    onTabClicked: (MainNavHostTab) -> Unit
) {
    val tabs = listOf(
        MainNavHostTab.Home,
        MainNavHostTab.Transactions,
        MainNavHostTab.Accounts,
    )

    BottomNavigation {
        tabs.forEach { tab ->
            BottomNavigationItem(
                modifier = Modifier.weight(1f),
                selected = tab == openedTab,
                onClick = { onTabClicked(tab) },
                icon = { },
                label = { Text(text = "Tab $tab") }
            )
        }
    }
}