package secrets

import com.android.build.gradle.internal.plugins.AppPlugin
import java.util.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.ProjectLayout
import org.gradle.api.provider.ProviderFactory
import secrets.Constants.BAKA_CLIENT_ID
import secrets.Constants.BAKA_CLIENT_SECRET
import secrets.Constants.SECRETS_PROP_FILE

class SecretsPlugin : Plugin<Project> {

  override fun apply(project: Project) {
    with(project) {
      val appPlugin =
        checkNotNull(plugins.findPlugin(AppPlugin::class.java)) {
          "Plugin 'com.android.application' must be applied to use this plugin"
        }

      val envResult = kotlin.runCatching { loadClientConfigFromEnvironment(providers) }
      if (envResult.isSuccess) {
        createBuildConfigFields(appPlugin, envResult.getOrThrow())
        return
      }

      val propResult = kotlin.runCatching { loadClientConfigFromProperties(providers, layout) }
      if (propResult.isSuccess) {
        createBuildConfigFields(appPlugin, envResult.getOrThrow())
        return
      }

      throw IllegalStateException(
        "client config not found in environment variables and 'secrets.properties'"
      )
    }
  }

  private fun loadClientConfigFromEnvironment(providers: ProviderFactory): ClientConfig {
    val envClientId = providers.environmentVariable(BAKA_CLIENT_ID).get()
    val envClientSecret = providers.environmentVariable(BAKA_CLIENT_SECRET).get()

    checkNotNull(envClientId) { "environment variable must contain a '$BAKA_CLIENT_ID' property" }

    checkNotNull(envClientSecret) {
      "environment variable must contain a '$BAKA_CLIENT_SECRET' property"
    }

    return ClientConfig(envClientId, envClientSecret)
  }

  private fun loadClientConfigFromProperties(
    providers: ProviderFactory,
    layout: ProjectLayout
  ): ClientConfig {
    val propFile = layout.projectDirectory.file(SECRETS_PROP_FILE)
    check(propFile.asFile.exists()) {
      "A 'secrets.properties' file must exist in the project subdirectory to use this plugin"
    }
    val contents = providers.fileContents(propFile).asText
    val versionProps = Properties().also { it.load(contents.get().byteInputStream()) }
    val clientId =
      checkNotNull(versionProps.getProperty(BAKA_CLIENT_ID)) {
        "secrets.properties must contain a '$BAKA_CLIENT_ID' property"
      }
    val clientSecret =
      checkNotNull(versionProps.getProperty(BAKA_CLIENT_SECRET)) {
        "secrets.properties must contain a '$BAKA_CLIENT_SECRET' property"
      }

    return ClientConfig(clientId, clientSecret)
  }

  private fun createBuildConfigFields(appPlugin: AppPlugin, clientConfig: ClientConfig) {
    appPlugin.extension.defaultConfig.buildConfigField(
      "String",
      BAKA_CLIENT_ID,
      clientConfig.clientId
    )
    appPlugin.extension.defaultConfig.buildConfigField(
      "String",
      BAKA_CLIENT_SECRET,
      clientConfig.clientSecret
    )
  }
}
