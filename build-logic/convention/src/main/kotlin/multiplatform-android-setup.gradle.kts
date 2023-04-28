import com.android.build.gradle.BaseExtension

plugins {
    id("multiplatform-setup")
}

configure<BaseExtension> {
    commonAndroid(project)
}

android {
    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml")
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }
}