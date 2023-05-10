package com.uladzislau_pravalenak.authorizationapp.signUp.presentation.model

sealed interface SignUpAction {

    object NavigateToSignIn : SignUpAction
    object ShowErrorDialog : SignUpAction
}