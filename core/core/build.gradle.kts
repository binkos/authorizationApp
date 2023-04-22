plugins {
    id("android-compose-setup")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.ktor.core)
    implementation(libs.ktor.okhttp)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.negotiation)
    implementation(libs.ktor.serialization.json)
}