plugins {
    id("multiplatform-android-setup")
}

android {
    namespace = "com.pracel.mvi"
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.androidx.lifecycle.viewmodel.ktx)
            }
        }

        commonMain {
            dependencies {
//                implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation(libs.coroutines.core)
            }
        }
    }
}