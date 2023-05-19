plugins {
//    id("android-compose-setup")
    id("multiplatform-android-setup")

}

android {
    namespace = "com.pracel.authorizationapp.home.impl"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(projects.feature.home.api)
                implementation(projects.feature.transactions.api)
                implementation(libs.coroutines.core)
            }
        }
    }
}