plugins{
    id("libraryPlugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.signUpFlow.enterData"
}

dependencies {
    implementation(projects.core.coreNavigation)
    implementation(projects.core.core)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
//    implementation(libs.androidx.navigation.compose.hilt)
}