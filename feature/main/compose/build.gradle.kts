plugins {
    id("android-compose-setup")
//    id("android-hilt-setup")
}

android {
    namespace = "com.pracel.authorizationapp.main.compose"
}

dependencies {
    implementation(projects.core.core)
    implementation(projects.core.coreUi)
    implementation(projects.core.coreNavigation)

    implementation(projects.feature.home.compose)
    implementation(projects.feature.accounts.api)
    implementation(projects.feature.transactions.api)
    implementation(projects.feature.analytics.api)
    implementation(projects.feature.transactionDetails.api)
    implementation(projects.feature.createTransaction.api)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.navigation)
    implementation(libs.compose.ui.preview)
    implementation(libs.compose.ui.tooling)

    implementation(libs.compose.accompanist.pager)
}