package com.uladzislau_pravalenak.authorizationapp.signIn.data.dto

data class SignInResponse(
    val statusCode: Int,
    val token: String,
    val refreshToken: String
)