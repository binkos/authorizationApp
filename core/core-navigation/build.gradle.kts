plugins {
    id("libraryPlugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.corenavigation"
}

dependencies {

    implementation(libs.compose.navigation)
//    implementation(libs.androidx.navigation.compose.hilt)
}