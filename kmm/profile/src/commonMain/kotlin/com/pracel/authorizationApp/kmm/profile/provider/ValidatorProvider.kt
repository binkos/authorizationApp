package com.pracel.authorizationApp.kmm.profile.provider

import com.pracel.authorizationApp.kmm.profile.api.ProfileValidator
import com.pracel.authorizationApp.kmm.profile.impl.DefaultProfileValidator

fun ProfileValidator(): ProfileValidator = DefaultProfileValidator()