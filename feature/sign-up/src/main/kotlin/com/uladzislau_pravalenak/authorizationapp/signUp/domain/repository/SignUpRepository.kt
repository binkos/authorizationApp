package com.uladzislau_pravalenak.authorizationapp.signUp.domain.repository

import com.uladzislau_pravalenak.authorizationapp.signUp.data.dto.SignUpResponse

interface SignUpRepository {
    suspend fun signUp(email: String, password: String): SignUpResponse
}