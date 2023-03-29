plugins {
    id("libraryPlugin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.onboarding"
}

dependencies {
    implementation(projects.core.core)
    implementation(projects.core.coreNavigation)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.navigation)
    implementation(libs.androidx.datastore)

    implementation(libs.compose.accompanist.pager)

    implementation(libs.androidx.navigation.compose.hilt)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}