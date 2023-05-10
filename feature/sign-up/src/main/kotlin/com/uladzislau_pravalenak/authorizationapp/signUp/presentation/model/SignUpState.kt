package com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model

import androidx.compose.runtime.Stable

@Stable
data class SignUpState(
    val email: String = "",
    val password: String = "",
    val emailError: String = "",
    val passwordError: String = "",
    val isSignInButtonEnabled: Boolean = false
)