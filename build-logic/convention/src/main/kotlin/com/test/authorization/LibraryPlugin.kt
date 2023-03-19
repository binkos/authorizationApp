import com.android.build.gradle.LibraryExtension
import com.test.authorization.internal.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class LibraryPlugin : Plugin<Project> {
	
	override fun apply(target: Project) = with(target) {
		with(pluginManager) {
			apply("com.android.library")
			apply("org.jetbrains.kotlin.android")
		}
		
		extensions.configure<LibraryExtension> {
			defaultConfig {
				minSdk = libs.versions.minSdk.get().toInt()
				compileSdk = libs.versions.compileSdk.get().toInt()
				
				consumerProguardFiles("consumer-rules.pro")
			}
			
			buildFeatures {
				buildConfig = false
			}
		}
	}
}
