plugins {
//    id("android-compose-setup")
    id("multiplatform-android-setup")

}

android {
    namespace = "com.pracel.authorizationapp.accounts.api"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
            }
        }
    }
}