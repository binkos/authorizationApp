package com.uladzislau_pravalenk.authorizationapp.core.data.dataStore

import androidx.datastore.preferences.core.booleanPreferencesKey

object AppConfigDataStorePreferencesKey {
    val passedKey = booleanPreferencesKey("onboarding_passed")
}