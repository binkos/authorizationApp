package com.uladzislau_pravalenak.authorizationapp.signIn.presentation.model

sealed interface SignInAction {

    object NavigateToMainFlow : SignInAction
    object NavigateToSignUpFlow : SignInAction
    object ShowErrorDialog : SignInAction
}