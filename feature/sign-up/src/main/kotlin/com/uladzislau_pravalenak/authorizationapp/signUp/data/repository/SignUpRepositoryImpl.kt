package com.uladzislau_pravalenak.authorizationapp.signUp.data.repository

import com.uladzislau_pravalenak.authorizationapp.signUp.data.dto.SignUpResponse
import com.uladzislau_pravalenak.authorizationapp.signUp.domain.repository.SignUpRepository
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class SignUpRepositoryImpl @Inject constructor(
    private val httpClient: HttpClient
) : SignUpRepository {

    override suspend fun signUp(email: String, password: String): SignUpResponse =
        withContext(Dispatchers.IO) {
//            val response = httpClient.post("signIn") {
//                setBody(SignInRequest(email, password))
//            }
//            response.body()

            SignUpResponse(200)
        }
}