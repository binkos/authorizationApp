import com.android.build.gradle.BaseExtension
import com.uladzislau_pravalenak.authorization.internal.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun BaseExtension.commonAndroid(target: Project) {
    configureDefaultConfig(target)
    configureBuildFeatures()
    configureBuildTypes()

    target.suppressOptIn()
}

private fun BaseExtension.configureDefaultConfig(target: Project) {
    compileSdkVersion(target.libs.versions.compileSdk.get().toInt())
    defaultConfig {
        minSdk = target.libs.versions.minSdk.get().toInt()

        consumerProguardFiles("consumer-rules.pro")

        packagingOptions {
            resources.excludes += "META-INF/LICENSE-LGPL-2.1.txt"
            resources.excludes += "META-INF/LICENSE-LGPL-3.txt"
            resources.excludes += "META-INF/LICENSE-W3C-TEST"
            resources.excludes += "META-INF/DEPENDENCIES"
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
//        testOptions {
//            unitTests {
//                isIncludeAndroidResources = true
//            }
//        }
    }
}

private fun BaseExtension.configureBuildTypes() {
    buildTypes {
        maybeCreate("release").apply {
            isMinifyEnabled = true
            proguardFiles(
                "proguard-rules.pro",
                getDefaultProguardFile("proguard-android-optimize.txt")
            )
        }
        maybeCreate("debug").apply {
            isMinifyEnabled = false
        }
    }
}

private fun BaseExtension.configureBuildFeatures() {
    buildFeatures.buildConfig = false
    buildFeatures.compose = false
}

private fun Project.suppressOptIn() {
    tasks.withType<KotlinCompile>()
        .configureEach {
            kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-opt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                    "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi",
                    "-opt-in=androidx.compose.material.ExperimentalMaterialApi",
                    "-opt-in=androidx.compose.ui.ExperimentalComposeUiApi",
                    "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                    "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
                    "-opt-in=kotlin.time.ExperimentalTime",
                    "-opt-in=kotlin.RequiresOptIn",
                    "-opt-in=androidx.compose.animation.ExperimentalAnimationApi",
                    "-opt-in=androidx.compose.foundation.layout.ExperimentalLayoutApi"
                )
            }
        }
}