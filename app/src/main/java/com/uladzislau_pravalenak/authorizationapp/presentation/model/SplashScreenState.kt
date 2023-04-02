package com.uladzislau_pravalenak.authorizationapp.presentation.model

import androidx.compose.runtime.Immutable
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes

@Immutable
data class SplashScreenState(
    val isOpen: Boolean = true,
    val destination: String = AppFlowRoutes.SPLASH.name
)
