plugins {
//    id("android-compose-setup")
    id("multiplatform-android-setup")

}

android {
    namespace = "com.pracel.authorizationapp.accounts.impl"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
            }
        }
    }
}