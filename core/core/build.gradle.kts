plugins {
    id("libraryPlugin")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp.core"
}

testPlugin {
    compose = false
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.runtime)
    implementation(libs.androidx.datastore)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}