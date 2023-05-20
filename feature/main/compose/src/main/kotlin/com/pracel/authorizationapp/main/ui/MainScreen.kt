package com.pracel.authorizationapp.main.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material.FloatingActionButton
import androidx.compose.foundation.layout.Spacer
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.pracel.authorizationapp.accounts.api.di.AccountComponentProvider
import com.pracel.authorizationapp.analytics.api.di.AnalyticsComponentProvider
import com.pracel.authorizationapp.main.navigation.MainNavHost
import com.pracel.authorizationapp.main.navigation.MainNavHostTab
import com.pracel.authorizationapp.transactions.api.di.TransactionsComponentProvider
import androidx.compose.material.primarySurface
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import com.pracel.authorizationapp.home.ui.TemporaryHomeScreen
import com.pracel.authorizationapp.main.navigation.MainFlowNavHostDestinations
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow

@Composable
fun MainScreen() {
//    val navigator = LocalNavigator.currentOrThrow
//    val navigationController = rememberNavController()
//    val navBackStackEntry by navigationController.currentBackStackEntryAsState()
//    val currentTab = navBackStackEntry?.destination?.route?.let { MainNavHostTab.valueOf(it) }

//    val onNavigate: (MainNavHostTab) -> Unit = remember {
//        { tab ->
//            navigationController.navigate(tab.name) {
//                navigationController.graph.startDestinationRoute?.let { route ->
//                    popUpTo(route) { saveState = true }
//                }
//                launchSingleTop = true
//                restoreState = true
//            }
//        }
//    }

    TemporaryHomeScreen()

//    Box {
//        val context = LocalContext.current.applicationContext
//        val transactionsComponent =
//            remember { (context as TransactionsComponentProvider).provideTransactionsComponent() }
//        val accountsComponent =
//            remember { (context as AccountComponentProvider).provideAccountComponent() }
//        val analyticsApi =
//            remember { (context as AnalyticsComponentProvider).provideAnalyticsComponent() }
//
//        MainNavHost(
//            modifier = Modifier
//                .fillMaxSize()
//                .navigationBarsPadding()
//                .padding(bottom = 56.dp),
//            navHostController = navigationController,
//            transactionsApi = transactionsComponent,
//            accountApi = accountsComponent,
//            analyticsApi = analyticsApi
//        )
//        BottomBar(
//            modifier = Modifier.align(Alignment.BottomCenter),
//            openedTab = currentTab,
//            onTabClicked = onNavigate,
//            backgroundColor = Color.Gray
//        ) {
//            navigator.navigate(MainFlowNavHostDestinations.TransactionDetails.name)
//        }
//    }
}

@Composable
private fun BottomBar(
    modifier: Modifier,
    openedTab: MainNavHostTab?,
    onTabClicked: (MainNavHostTab) -> Unit,
    backgroundColor: Color,
    onButtonClicked: () -> Unit
) {

    // TODO: Change wrapping of BOX for setting color of navigation bar to approach with systemUi
    Box(modifier = modifier) {
        Box(
            Modifier
                .padding(top = 28.dp)
                .background(backgroundColor)
        ) {
            BottomNavigation(
                modifier = Modifier.navigationBarsPadding(),
                elevation = 0.dp,
                backgroundColor = backgroundColor
            ) {
                BottomNavigationItem(selected = MainNavHostTab.Home == openedTab,
                    onClick = { onTabClicked(MainNavHostTab.Home) },
                    label = { Text(text = MainNavHostTab.Home.name) },
                    icon = { })
                BottomNavigationItem(selected = MainNavHostTab.Transactions == openedTab,
                    onClick = { onTabClicked(MainNavHostTab.Transactions) },
                    label = { Text(text = MainNavHostTab.Transactions.name, fontSize = 11.sp) },
                    icon = { })
                Spacer(modifier = Modifier.weight(0.2f))
                BottomNavigationItem(selected = MainNavHostTab.Accounts == openedTab,
                    onClick = { onTabClicked(MainNavHostTab.Accounts) },
                    label = { Text(text = MainNavHostTab.Accounts.name) },
                    icon = { })
                BottomNavigationItem(selected = MainNavHostTab.Analytics == openedTab,
                    onClick = { onTabClicked(MainNavHostTab.Analytics) },
                    label = { Text(text = MainNavHostTab.Analytics.name) },
                    icon = { })
            }
        }

        FloatingActionButton(
            modifier = Modifier.align(Alignment.TopCenter),
            onClick = onButtonClicked,
            backgroundColor = Color.Cyan
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add",
            )
        }
    }
}