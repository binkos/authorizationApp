package com.pracel.authorizationapp.analytics.impl.di

import com.pracel.authorizationapp.analytics.api.di.AnalyticsUiModule

actual fun AnalyticsUiModuleImpl() : AnalyticsUiModule = com.pracel.authorizationapp.analytics.di.AnalyticsUiModule()