package com.uladzislau_pravalenk.authorizationapp.core.data.remote

import android.util.Log
import com.uladzislau_pravalenak.authorizationapp.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(OkHttp) {
            expectSuccess = false
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    coerceInputValues = true
                })
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 60_000L
                connectTimeoutMillis = 60_000L
            }
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTP
                    host = BuildConfig.baseUrl
                    contentType(ContentType.Application.Json)
                }
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.i("KTOR Client", message)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }
}