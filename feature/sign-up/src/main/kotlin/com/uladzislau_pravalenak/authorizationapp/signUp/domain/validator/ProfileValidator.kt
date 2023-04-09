package com.uladzislau_pravalenak.authorizationapp.signUp.domain.validator

interface ProfileValidator {

    fun validateEmail(email: String): Boolean

    fun validatePassword(password: String): Boolean
}