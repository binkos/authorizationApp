import com.android.build.api.dsl.ApplicationExtension
import com.test.authorization.internal.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target.pluginManager) {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
        }

        target.extensions.configure<ApplicationExtension> {
			buildFeatures {
				compose = true

				composeOptions {
					kotlinCompilerExtensionVersion = target.libs.versions.composeCompiler.get()
				}
			}
        }
    }
}
