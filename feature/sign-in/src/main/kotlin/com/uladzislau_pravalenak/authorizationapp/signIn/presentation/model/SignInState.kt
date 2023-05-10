package com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class SignInState(
    val email: String = "",
    val password: String = "",
    val emailError: String = "",
    val passwordError: String = "",
    val isSignInButtonEnabled: Boolean = false
)