package com.pracel.authorizationapp.analytics.di

import androidx.compose.runtime.Composable
import com.pracel.authorizationapp.analytics.api.di.AnalyticsUiModule
import com.pracel.authorizationapp.analytics.ui.AnalyticsScreen

class AnalyticsUiModule: AnalyticsUiModule {
    @Composable
    override fun ComposableAnalyticsScreen() = AnalyticsScreen()
}