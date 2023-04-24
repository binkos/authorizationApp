plugins{
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradle.plugin.kotlin)
    implementation(libs.gradle.plugin.buildtools)
    implementation(libs.gradle.plugin.hilt)

    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

//gradlePlugin {
//    plugins {
//        register("androidLibrary") {
//            id = "libraryPlugin"
//            implementationClass = "LibraryPlugin"
//        }
//    }
//}