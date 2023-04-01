package com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model

sealed class SignInEvent private constructor() {

    data class EmailChanged(val value: String) : SignInEvent()
    data class PasswordChanged(val value: String) : SignInEvent()
    object ForgotPasswordClicked : SignInEvent()
    object SignInButtonClicked : SignInEvent()
}
