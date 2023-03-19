plugins{
    `kotlin-dsl`
}

group = "com.test.authorization"

dependencies {
    compileOnly(libs.gradle.plugin.kotlin)
    compileOnly(libs.gradle.plugin.buildtools)

    compileOnly(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    plugins {
        register("androidLibrary") {
            id = "libraryPlugin"
            implementationClass = "LibraryPlugin"
        }
    }
}