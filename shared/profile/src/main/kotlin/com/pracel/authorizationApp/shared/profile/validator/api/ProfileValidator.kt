package com.pracel.authorizationApp.shared.profile.validator.api

interface ProfileValidator {

    fun validateEmail(email: String): Boolean

    fun validatePassword(password: String): Boolean
}