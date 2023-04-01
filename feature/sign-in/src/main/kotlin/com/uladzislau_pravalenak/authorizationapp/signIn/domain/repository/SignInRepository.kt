package com.uladzislau_pravalenak.authorizationapp.signIn.domain.repository

import com.uladzislau_pravalenak.authorizationapp.signIn.data.dto.SignInResponse

interface SignInRepository {
    suspend fun login(email: String, password: String): SignInResponse
}