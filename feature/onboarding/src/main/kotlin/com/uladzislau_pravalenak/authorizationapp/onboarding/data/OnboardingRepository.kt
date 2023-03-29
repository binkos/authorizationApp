package com.uladzislau_pravalenak.authorizationapp.onboarding.data

import kotlinx.coroutines.flow.Flow

interface OnboardingRepository {

    val isOnboardingPassed: Flow<Boolean>

    suspend fun setOnboardingPassed(isPassed: Boolean)
}