plugins {
    id("android-compose-setup")
    id("android-hilt-setup")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.signIn"
}

dependencies {
    implementation(projects.core.core)
    implementation(projects.core.coreUi)
    implementation(projects.core.coreNavigation)

//    implementation(projects.kmm.profile)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.compose.ui.preview)
    implementation(libs.compose.ui.tooling)

    implementation(libs.ktor.core)
    implementation(libs.ktor.okhttp)

    implementation(libs.androidx.navigation.compose.hilt)

    implementation(libs.androidx.datastore)
}