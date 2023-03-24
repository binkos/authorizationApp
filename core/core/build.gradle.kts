plugins {
    id("libraryPlugin")
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
}

dependencies {
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.runtime)
}