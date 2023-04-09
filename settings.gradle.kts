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
include(":core:core-navigation")

include(":feature:main")
include(":feature:onboarding")
include(":feature:sign-in")
include(":feature:splash")

include(":feature:sign-up")
include(":shared:api")
include(":shared:auth")
include(":shared:start-destination")
