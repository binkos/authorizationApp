package com.pracel.authorizationApp.shared.profile.validator.impl

import android.util.Patterns
import com.pracel.authorizationApp.shared.profile.validator.api.ProfileValidator
import javax.inject.Inject

internal class DefaultProfileValidator @Inject constructor() : ProfileValidator {

    override fun validateEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun validatePassword(password: String): Boolean {
        return password.length > 8
    }
}