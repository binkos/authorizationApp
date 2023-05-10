import com.uladzislau_pravalenak.authorization.internal.libs

plugins {
    id("multiplatform-android-setup")
//    id("org.jetbrains.compose")
}

android {
    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}

kotlin {
//    jvm("desktop")
    android()
//    android()

    sourceSets {
        named("commonMain") {
            dependencies {
//                implementation(compose.runtime)
//                implementation(compose.foundation)
//                implementation(compose.material)
            }
        }

//        named("desktopMain") {
//            dependencies {
//                implementation(compose.desktop.common)
//            }
//        }

        named("androidMain") {
            dependencies {
//                implementation(Dependencies.Android.Compose.ui)
//                implementation(Dependencies.Android.Compose.material)
//                implementation(Dependencies.Android.Compose.tooling)
//                implementation(Dependencies.Android.Compose.icons)
            }
        }
    }
}