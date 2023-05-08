plugins {
//    id("android-compose-setup")
    id("multiplatform-android-setup")

}

android {
    namespace = "com.pracel.authorizationapp.home.api"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies { implementation(projects.feature.transactions.api) }
        }
    }
}