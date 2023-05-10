package com.uladzislau_pravalenk.authorizationapp.core.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

private const val PROFILE_DATA_STORE_PREFERENCES_KEY = "profile"
private const val APP_CONFIG_DATA_STORE_PREFERENCES_KEY = "app_config"

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Singleton
    @ProfileDataStore
    fun providesProfileDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            produceFile = { context.preferencesDataStoreFile(PROFILE_DATA_STORE_PREFERENCES_KEY) }
        )
    }

    @Provides
    @Singleton
    @AppConfigDataStore
    fun providesAppConfigDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            produceFile = { context.preferencesDataStoreFile(APP_CONFIG_DATA_STORE_PREFERENCES_KEY) }
        )
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppConfigDataStore

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ProfileDataStore

