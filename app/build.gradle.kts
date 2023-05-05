plugins {
    id("android-app-setup")
    id("android-hilt-setup")
}

android {
    buildFeatures {
        compose = true

        composeOptions {
            kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
        }
    }
}

dependencies {
    implementation(projects.core.coreUi)
    implementation(projects.core.core)
    implementation(projects.core.coreNavigation)

    implementation(projects.feature.signUp)
    implementation(projects.feature.onboarding)
    implementation(projects.feature.signIn)
    implementation(projects.feature.splash)
    implementation(projects.feature.main.compose)

    implementation(projects.feature.accounts.api)
    implementation(projects.feature.accounts.impl)

    implementation(projects.shared.startDestination)

    implementation(libs.compose.navigation)
    implementation(libs.androidx.splashscreen)
    implementation(libs.androidx.datastore)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
}