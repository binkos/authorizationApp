package com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model

sealed class SignUpEvent private constructor() {

    data class EmailChanged(val value: String) : SignUpEvent()
    data class PasswordChanged(val value: String) : SignUpEvent()
    object SignUpButtonClicked : SignUpEvent()
}
