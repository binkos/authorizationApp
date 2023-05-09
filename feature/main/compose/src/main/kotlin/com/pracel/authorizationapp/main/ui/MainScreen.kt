package com.pracel.authorizationapp.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
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
            modifier = Modifier.padding(bottom = it.calculateBottomPadding()),
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

    Box(Modifier.background(Color.Gray).clip(RectangleShape)) {
        Row(
            modifier = Modifier
                .navigationBarsPadding()
                .height(56.dp)
        ) {
            tabs.forEach { tab ->
                BottomNavigationItem(
                    modifier = Modifier.background(Color.Gray),
                    selected = tab == openedTab,
                    onClick = { onTabClicked(tab) },
                    icon = { },
                    label = { Text(text = "Tab $tab") }
                )
            }
        }
    }

//    Box(Modifier.background(Color.Gray)) {
//        BottomNavigation(
//            modifier = Modifier.navigationBarsPadding(),
//            backgroundColor = Color.Gray
//        ) {
//            tabs.forEach { tab ->
//                BottomNavigationItem(
//                    modifier = Modifier.background(Color.Gray),
//                    selected = tab == openedTab,
//                    onClick = { onTabClicked(tab) },
//                    icon = { },
//                    label = { Text(text = "Tab $tab") }
//                )
//            }
//        }
//    }
}