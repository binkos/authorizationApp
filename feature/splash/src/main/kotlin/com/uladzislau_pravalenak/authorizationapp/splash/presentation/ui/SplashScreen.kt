package com.uladzislau_pravalenak.authorizationapp.splash.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.uladzislau_pravalenak.authorization.core.ui.theme.Teal200
import com.uladzislau_pravalenak.authorizationapp.core.navigation.navigator.LocalNavigator
import com.uladzislau_pravalenak.authorizationapp.coreui.R
import com.uladzislau_pravalenak.authorizationapp.splash.presentation.SplashScreenViewModel
import com.uladzislau_pravalenk.authorizationapp.core.extensions.currentOrThrow
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen() {
    val navigator = LocalNavigator.currentOrThrow

    val viewModel: SplashScreenViewModel = hiltViewModel()

    LaunchedEffect(key1 = Unit) {
        delay(1000)
    }

    SplashScreenUI()
}


@Composable
private fun SplashScreenUI() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Teal200),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "splash_foreground"
        )
    }
}