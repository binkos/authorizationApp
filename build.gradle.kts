@file:Suppress("DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.serialization.plugin) apply false
}

buildscript {
    repositories {
        google()
    }

}// Top-level build file where you can add configuration options common to all sub-projects/modules.