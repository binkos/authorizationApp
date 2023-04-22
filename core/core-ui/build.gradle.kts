plugins {
    id("android-compose-setup")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.coreui"
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.foundation)
    implementation(libs.compose.material)
    implementation(libs.compose.material.icons)
}