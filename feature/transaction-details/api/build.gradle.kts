plugins {
    id("multiplatform-compose-setup")
}

android {
    namespace = "com.pracel.authorizationapp.transaction.details.api"
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(project.dependencies.platform(libs.compose.bom))
                implementation(libs.compose.foundation)
                implementation(libs.compose.ui)
                implementation(libs.compose.material)
                implementation(libs.compose.material.icons)
                implementation(libs.compose.navigation)
                implementation(libs.compose.ui.preview)
                implementation(libs.compose.ui.tooling)
            }
        }

        commonMain {
            dependencies {
//                implementation(projects.core.coreDi)
            }
        }

    }
}