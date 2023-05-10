import com.android.build.gradle.BaseExtension
import com.uladzislau_pravalenak.authorization.internal.AppConfig

plugins {
    id("com.android.application")
    id("kotlin-android")
}

configure<BaseExtension> {
    commonAndroid(project)
    namespace = "com.uladzislau_pravalenak.authorizationapp"

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
    }

//    buildTypes {
//        internal {
//            isShrinkResources = true
//        }
//        release {
//            isShrinkResources = true
//        }
//    }
}

//configure<ApplicationExtension> {
//    // https://issuetracker.google.com/issues/162074215
//    dependenciesInfo {
//        includeInBundle = false
//        includeInApk = false
//    }
//}
