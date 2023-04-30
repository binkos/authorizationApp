plugins {
    id("android-compose-setup")
//    id("android-hilt-setup")
}

android {
    namespace = "com.pracel.authorizationapp.home.compose"
}

dependencies {
    implementation(projects.core.core)
    implementation(projects.core.coreUi)
    implementation(projects.core.coreNavigation)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.material.icons)
    implementation(libs.compose.navigation)
    implementation(libs.compose.ui.preview)
    implementation(libs.compose.ui.tooling)
}