plugins {
    id("android-compose-setup")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.corenavigation"
}

dependencies {

    implementation(libs.compose.navigation)
//    implementation(libs.androidx.navigation.compose.hilt)
}