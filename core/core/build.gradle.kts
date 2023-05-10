plugins {
    id("android-compose-setup")
    id("android-hilt-setup")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.core"

    buildFeatures {
        buildConfig = true
    }

    defaultConfig {
        buildConfigField("String", "baseUrl", "\"baseurl\"")
    }
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.runtime)
    implementation(libs.androidx.datastore)

    implementation(libs.ktor.core)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.serialization.json)
}