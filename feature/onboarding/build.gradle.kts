plugins {
    id("libraryPlugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.onboarding"
}

dependencies {
    implementation(projects.core.core)
    implementation(projects.core.coreNavigation)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.navigation)

    implementation(libs.compose.accompanist.pager)
}