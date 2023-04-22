plugins {
    id("android-app-setup")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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

    implementation(projects.shared.startDestination)

    implementation(libs.compose.navigation)
    implementation(libs.androidx.splashscreen)
    implementation(libs.androidx.datastore)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
}