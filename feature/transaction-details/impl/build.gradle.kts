plugins {
//    id("android-compose-setup")
    id("multiplatform-android-setup")

}

android {
    namespace = "com.pracel.authorizationapp.transaction.details.impl"
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(projects.feature.transactionDetails.compose)

                implementation(project.dependencies.platform(libs.compose.bom))
                implementation(libs.compose.foundation)
                implementation(libs.compose.ui)
                implementation(libs.compose.material)
                implementation(libs.compose.material.icons)
                implementation(libs.compose.ui.preview)
                implementation(libs.compose.ui.tooling)
            }
        }
        commonMain {
            dependencies {
                implementation(libs.coroutines.core)
                implementation(projects.feature.transactionDetails.api)
            }
        }
    }
}