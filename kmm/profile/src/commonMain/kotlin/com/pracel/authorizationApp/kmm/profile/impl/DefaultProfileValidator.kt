package com.pracel.authorizationApp.kmm.profile.impl

import com.pracel.authorizationApp.kmm.profile.api.ProfileValidator

class DefaultProfileValidator : ProfileValidator {

    override fun validateEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS_REGEX.matches(email)
    }

    override fun validatePassword(password: String): Boolean {
        return password.length > 8
    }
}