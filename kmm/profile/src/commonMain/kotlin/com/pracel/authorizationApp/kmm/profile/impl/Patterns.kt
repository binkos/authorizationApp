package com.pracel.authorizationApp.kmm.profile.impl

internal object Patterns {
    val EMAIL_ADDRESS_REGEX: Regex =
        "[a-zA-Z0-9+._%\\-]{1,256}@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+".toRegex()

}