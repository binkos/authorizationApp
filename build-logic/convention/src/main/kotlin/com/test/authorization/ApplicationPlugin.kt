import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationPlugin : Plugin<Project> {
	
	override fun apply(target: Project) {
		with(target.pluginManager) {
			apply("com.android.application")
			apply("org.jetbrains.kotlin.android")
		}
	}
}
