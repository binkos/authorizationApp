package com.uladzislau_pravalenak.authorization.internal

import org.gradle.api.Project

object AppConfig {
    const val APPLICATION_ID = "com.uladzislau_pravalenak.authorizationapp"

    const val MIN_SDK_VERSION = 26
    const val TARGET_SDK_VERSION = 33
    const val COMPILE_SDK_VERSION = 33
}

private fun Project.prop(key: String, default: Any): String {
    return providers.gradleProperty(key).getOrElse(default.toString())
}