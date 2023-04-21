plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.uladzislau_pravalenak.authorizationapp"

    defaultConfig {
        applicationId = "com.uladzislau_pravalenak.authorizationapp"
        minSdk = libs.versions.minSdk.get().toInt()
        compileSdk = libs.versions.compileSdk.get().toInt()
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                "proguard-rules.pro",
                getDefaultProguardFile("proguard-android-optimize.txt")
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        compose = true

        composeOptions {
            kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
        }
    }

    project.tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>()
        .configureEach {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
}

dependencies {
    implementation(projects.core.coreUi)
    implementation(projects.core.core)
    implementation(projects.core.coreNavigation)

    implementation(projects.feature.signUp)
    implementation(projects.feature.onboarding)
    implementation(projects.feature.signIn)
    implementation(projects.feature.splash)

    implementation(projects.shared.startDestination)

    implementation(libs.compose.navigation)
    implementation(libs.androidx.splashscreen)
    implementation(libs.androidx.datastore)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}