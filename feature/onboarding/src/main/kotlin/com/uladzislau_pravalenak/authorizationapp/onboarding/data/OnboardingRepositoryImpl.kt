package com.uladzislau_pravalenak.authorizationapp.onboarding.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.uladzislau_pravalenk.authorizationapp.core.data.dataStore.AppConfigDataStorePreferencesKey
import com.uladzislau_pravalenk.authorizationapp.core.di.AppConfigDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class OnboardingRepositoryImpl @Inject constructor(
    @AppConfigDataStore
    private val appConfigDataStore: DataStore<Preferences>
) : OnboardingRepository {

    override val isOnboardingPassed: Flow<Boolean>
        get() = appConfigDataStore.data.map { preferences ->
            preferences[AppConfigDataStorePreferencesKey.passedKey] ?: false
        }

    override suspend fun setOnboardingPassed(isPassed: Boolean) {
        appConfigDataStore.edit { preferences ->
            preferences[AppConfigDataStorePreferencesKey.passedKey] = isPassed
        }
    }
}