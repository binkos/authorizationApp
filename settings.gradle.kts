enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("STABLE_CONFIGURATION_CACHE")
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
include(":core:core-di")
include(":core:core-navigation")

include(":feature:main:api")
include(":feature:main:impl")
include(":feature:main:compose")

include(":feature:home:api")
include(":feature:home:impl")
include(":feature:home:compose")

include(":feature:accounts:api")
include(":feature:accounts:impl")
include(":feature:accounts:compose")

include(":feature:transactions:api")
include(":feature:transactions:impl")
include(":feature:transactions:compose")

include(":feature:transaction-details:api")
include(":feature:transaction-details:impl")
include(":feature:transaction-details:compose")

include(":feature:create-transaction:api")
include(":feature:create-transaction:impl")
include(":feature:create-transaction:compose")

include(":feature:analytics:api")
include(":feature:analytics:impl")
include(":feature:analytics:compose")

include(":feature:onboarding")
include(":feature:sign-in")
include(":feature:splash")

include(":feature:sign-up")
include(":shared:api")
include(":shared:auth")
include(":shared:start-destination")
//include(":shared:profile")

include(":kmm:profile")
include(":library:mvi")
