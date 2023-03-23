plugins {
    id("libraryPlugin")
}

android {
    namespace = "com.test.authorizationapp.corenavigation"
}

dependencies {

    implementation(libs.androidx.navigation.compose)
//    implementation(libs.androidx.navigation.compose.hilt)
}