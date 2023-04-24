import com.uladzislau_pravalenak.authorization.internal.libs

plugins {
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

dependencies {
    "implementation"(libs.hilt.android)
    "kapt"(libs.hilt.compiler)
}

//configure<BaseExtension> {
//    dependencies {
//
//    }
////    commonAndroid(project)
//}
