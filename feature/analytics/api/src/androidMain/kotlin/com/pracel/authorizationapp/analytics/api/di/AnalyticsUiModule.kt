package com.pracel.authorizationapp.analytics.api.di

import androidx.compose.runtime.Composable

actual interface AnalyticsUiModule {

    @Composable
    fun ComposableAnalyticsScreen()
}