enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "authorizationApp"
include(":app")

include(":core:core")
include(":core:core-ui")

include(":feature:main")
include(":feature:onboarding")

include(":feature:signupFlow:main")
include(":feature:signupFlow:auth")
include(":feature:signupFlow:signup")

include(":shared:api")
include(":shared:auth")
