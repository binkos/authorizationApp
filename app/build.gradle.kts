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
    implementation(projects.core.coreDi)
    implementation(projects.core.coreNavigation)

    implementation(projects.feature.signUp)
    implementation(projects.feature.onboarding)
    implementation(projects.feature.signIn)
    implementation(projects.feature.splash)
    implementation(projects.feature.main.compose)

    implementation(projects.feature.accounts.api)
    implementation(projects.feature.accounts.compose)
    implementation(projects.feature.accounts.impl)

    implementation(projects.feature.home.api)
    implementation(projects.feature.home.impl)

    implementation(projects.feature.transactions.api)
    implementation(projects.feature.transactions.compose)
    implementation(projects.feature.transactions.impl)

    implementation(projects.feature.analytics.api)
    implementation(projects.feature.analytics.compose)
    implementation(projects.feature.analytics.impl)

    implementation(projects.feature.transactionDetails.api)
    implementation(projects.feature.transactionDetails.compose)
    implementation(projects.feature.transactionDetails.impl)

    implementation(projects.feature.createTransaction.api)
    implementation(projects.feature.createTransaction.compose)
    implementation(projects.feature.createTransaction.impl)

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