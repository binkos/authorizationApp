plugins{
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
    maven(url = "https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(libs.gradle.plugin.kotlin)
    implementation(libs.gradle.plugin.buildtools)
    implementation(libs.gradle.plugin.hilt)
//    implementation("org.jetbrains.compose:compose-gradle-plugin:1.2.0")

    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
