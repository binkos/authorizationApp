package com.uladzislau_pravalenak.authorizationapp.onboarding

sealed class OnboardingAction {

    object NavigateToSignIn : OnboardingAction()
    object NavigateToSignUp : OnboardingAction()
}
