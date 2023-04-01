package com.uladzislau_pravalenak.authorizationapp.signIn.data.repository

import com.uladzislau_pravalenak.authorizationapp.signIn.data.dto.SignInResponse
import com.uladzislau_pravalenak.authorizationapp.signIn.domain.repository.SignInRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SignInRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : SignInRepository {

    override suspend fun login(email: String, password: String): SignInResponse =
        withContext(Dispatchers.IO) {
//            val response = httpClient.post("signIn") {
//                setBody(SignInRequest(email, password))
//            }
//            response.body()

            SignInResponse(200, "", "")
        }
}