plugins {
    id("libraryPlugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.signUpFlow.root"
}

dependencies {
    implementation(projects.core.coreNavigation)
    implementation(projects.core.core)
    implementation(projects.feature.signUpFlow.enterData)

    implementation(libs.compose.navigation)
//    implementation(libs.androidx.navigation.compose.hilt)
}
