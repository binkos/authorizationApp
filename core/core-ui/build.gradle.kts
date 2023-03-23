plugins {
    id("libraryPlugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.coreui"
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
}