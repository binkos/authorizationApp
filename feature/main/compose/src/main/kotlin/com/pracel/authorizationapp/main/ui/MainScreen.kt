package com.pracel.authorizationapp.main.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen() {

    MainScreenUI()
}

@Composable
private fun MainScreenUI() {
    Scaffold(
        bottomBar = { BottomBar() }
    ) {
        it.calculateBottomPadding()


    }
}

@Composable
fun BottomBar() {
    BottomNavigation {
        repeat(3) {
            BottomNavigationItem(
                modifier = Modifier.weight(1f),
                selected = true,
                onClick = { },
                icon = { }
            )
        }
    }
}