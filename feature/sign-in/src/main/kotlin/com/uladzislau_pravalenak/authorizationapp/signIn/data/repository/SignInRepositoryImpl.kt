package com.uladzislau_pravalenak.authorizationapp.signIn.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.uladzislau_pravalenak.authorizationapp.signIn.data.dto.SignInResponse
import com.uladzislau_pravalenak.authorizationapp.signIn.domain.repository.SignInRepository
import com.uladzislau_pravalenk.authorizationapp.core.data.dataStore.AppConfigDataStorePreferencesKey
import com.uladzislau_pravalenk.authorizationapp.core.di.AppConfigDataStore
import com.uladzislau_pravalenk.authorizationapp.core.routes.AppFlowRoutes
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SignInRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient,
    @AppConfigDataStore
    private val appConfigDataStore: DataStore<Preferences>
) : SignInRepository {

    override suspend fun login(email: String, password: String): SignInResponse =
        withContext(Dispatchers.IO) {
//            val response = httpClient.post("signIn") {
//                setBody(SignInRequest(email, password))
//            }
//            response.body()

            appConfigDataStore.edit {
                it[AppConfigDataStorePreferencesKey.startDestination] = AppFlowRoutes.MAIN_FLOW.name
//                it[token] = token
//                it[refreshToken] = refreshToken
            }
            SignInResponse(200, "", "")
        }
}