package com.uladzislau_pravalenak.authorizationapp.shared.startDestionation.domain

import kotlinx.coroutines.flow.Flow

interface StartDestinationRepository {

    val startDestination: Flow<String>

    suspend fun setStartDestination(destination: String)

}