package secrets

import com.android.build.gradle.internal.plugins.AppPlugin
import java.util.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import secrets.Constants.BAKA_CLIENT_ID
import secrets.Constants.BAKA_CLIENT_SECRET
import secrets.Constants.SECRETS_PROP_FILE

class SecretsPlugin : Plugin<Project> {

  override fun apply(project: Project) {
    with(project) {
      val appPlugin =
        requireNotNull(plugins.findPlugin(AppPlugin::class.java)) {
          "Plugin 'com.android.application' must be applied to use this plugin"
        }
      val propFile = layout.projectDirectory.file(SECRETS_PROP_FILE)
      require(propFile.asFile.exists()) {
        "A 'secrets.properties' file must exist in the project subdirectory to use this plugin"
      }
      val contents = providers.fileContents(propFile).asText
      val versionProps = Properties().also { it.load(contents.get().byteInputStream()) }
      val clientId =
        requireNotNull(versionProps.getProperty(BAKA_CLIENT_ID)) {
          "version.properties must contain a '$BAKA_CLIENT_ID' property"
        }
      val clientSecret =
        requireNotNull(versionProps.getProperty(BAKA_CLIENT_SECRET)) {
          "version.properties must contain a '$BAKA_CLIENT_SECRET' property"
        }
      appPlugin.extension.defaultConfig.buildConfigField("String", "BAKA_CLIENT_ID", clientId)
      appPlugin.extension.defaultConfig.buildConfigField(
        "String",
        "BAKA_CLIENT_SECRET",
        clientSecret
      )
    }
  }
}
