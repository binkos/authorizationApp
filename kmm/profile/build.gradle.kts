plugins {
    id("multiplatform-setup")
    id("multiplatform-android-setup")
}

android {
    namespace = "com.pracel.authorizationapp.kmm.profile"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {

            }
        }
    }
}