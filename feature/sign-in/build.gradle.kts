plugins {
    id("libraryPlugin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.signIn"
}

dependencies {
    implementation(projects.core.core)
    implementation(projects.core.coreUi)
    implementation(projects.core.coreNavigation)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.compose.ui.preview)
    implementation(libs.compose.ui.tooling)

    implementation(libs.ktor.core)
    implementation(libs.ktor.okhttp)

    implementation(libs.androidx.navigation.compose.hilt)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}