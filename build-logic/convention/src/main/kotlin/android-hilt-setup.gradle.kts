import com.uladzislau_pravalenak.authorization.internal.libs

plugins {
    id("dagger.hilt.android.plugin")
    kotlin("kapt")
}

dependencies {
    "implementation"(libs.hilt.android)
    "kapt"(libs.hilt.compiler)
}
