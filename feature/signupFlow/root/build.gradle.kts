plugins {
    id("libraryPlugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.signupFlow.root"
}

dependencies {
    implementation(projects.core.coreNavigation)

    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.navigation.compose.hilt)
}

