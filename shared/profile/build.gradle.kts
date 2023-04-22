plugins {
    id("android-compose-setup")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.shared.profile"
}

dependencies {
//    implementation(projects.core.coreUi)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
//    implementation(libs.compose.material)
//    implementation(libs.compose.ui.preview)
//    implementation(libs.compose.ui.tooling)
//
//    implementation(libs.androidx.navigation.compose.hilt)
//    implementation(libs.hilt.android)
//    kapt(libs.hilt.compiler)
}