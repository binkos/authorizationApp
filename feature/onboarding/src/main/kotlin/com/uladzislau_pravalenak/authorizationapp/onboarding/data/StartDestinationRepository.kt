package com.uladzislau_pravalenak.authorizationapp.onboarding.data

import kotlinx.coroutines.flow.Flow

interface StartDestinationRepository {

    val startDestination: Flow<String>

    suspend fun setStartDestination(destination: String)

}