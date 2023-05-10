import com.android.build.gradle.BaseExtension
import com.uladzislau_pravalenak.authorization.internal.libs

plugins {
    id("android-lib-setup")
}

@Suppress("UnstableApiUsage")
configure<BaseExtension> {
    buildFeatures.compose = true

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
}
