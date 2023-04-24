package com.pracel.authorizationApp.kmm.profile.api

interface ProfileValidator {

    fun validateEmail(email: String): Boolean

    fun validatePassword(password: String): Boolean
}