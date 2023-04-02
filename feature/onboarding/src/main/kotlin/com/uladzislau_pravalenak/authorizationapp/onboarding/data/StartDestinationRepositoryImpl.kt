package com.uladzislau_pravalenak.authorizationapp.onboarding.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.uladzislau_pravalenk.authorizationapp.core.data.dataStore.AppConfigDataStorePreferencesKey
import com.uladzislau_pravalenk.authorizationapp.core.di.AppConfigDataStore
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class StartDestinationRepositoryImpl @Inject constructor(
    @AppConfigDataStore
    private val appConfigDataStore: DataStore<Preferences>
) : StartDestinationRepository {

    override val startDestination: Flow<String>
        get() = appConfigDataStore.data.map { preferences ->
            preferences[AppConfigDataStorePreferencesKey.startDestination]
                ?: AppFlowRoutes.ONBOARDING.name
        }

    override suspend fun setStartDestination(destination: String) {
        appConfigDataStore.edit { preferences ->
            preferences[AppConfigDataStorePreferencesKey.startDestination] = destination
        }
    }
}