import com.test.authorization.PluginExtension
import com.test.authorization.internal.libraryExtensions
import com.test.authorization.internal.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.dependencies

class LibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.library")
            apply("kotlin-android")
        }

        libraryExtensions.run {
            defaultConfig {
                minSdk = libs.versions.minSdk.get().toInt()
                compileSdk = libs.versions.compileSdk.get().toInt()

                consumerProguardFiles("consumer-rules.pro")
            }
            val pluginExtension = project.extensions.create<PluginExtension>("testPlugin")

            buildFeatures {
                buildConfig = pluginExtension.buildConfigGeneration
                compose = pluginExtension.compose

                composeOptions {
                    kotlinCompilerExtensionVersion = project.libs.versions.composeCompiler.get()
                }
            }
        }
    }
}
