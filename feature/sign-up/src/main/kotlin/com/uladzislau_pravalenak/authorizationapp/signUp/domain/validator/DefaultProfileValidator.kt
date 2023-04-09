package com.uladzislau_pravalenak.authorizationapp.signUp.domain.validator

import android.util.Patterns
import javax.inject.Inject

class DefaultProfileValidator @Inject constructor() : ProfileValidator {

    override fun validateEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun validatePassword(password: String): Boolean {
        return password.length > 8
    }
}