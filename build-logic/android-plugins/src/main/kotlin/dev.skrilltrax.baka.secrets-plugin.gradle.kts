import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import com.android.build.api.variant.BuildConfigField
import java.util.Properties
import secrets.ClientConfig
import secrets.Constants.BAKA_CLIENT_ID
import secrets.Constants.BAKA_CLIENT_SECRET
import secrets.Constants.SECRETS_PROP_FILE

plugins { id("com.android.application") }

androidComponents {
  val projectDirectory = project.layout.projectDirectory
  val config =
    loadSecretsFromProperties(projectDirectory) ?: loadSecretsFromEnvironment() ?: defaultConfig()
  addSecretsToBuildConfig(config)
}

fun defaultConfig(): ClientConfig {
  project.logger.lifecycle(
    "[SecretsPlugin]: Failed to load secrets from environment or '$SECRETS_PROP_FILE'"
  )
  return ClientConfig("", "")
}

fun loadSecretsFromProperties(projectDirectory: Directory): ClientConfig? {
  val providers = project.providers
  val secretsFile = projectDirectory.file(SECRETS_PROP_FILE)

  if (!secretsFile.asFile.exists()) return null
  val contents = providers.fileContents(secretsFile).asText
  val secretProps = Properties().also { it.load(contents.get().byteInputStream()) }
  val clientId = secretProps.getProperty(BAKA_CLIENT_ID) ?: return null
  val clientSecret = secretProps.getProperty(BAKA_CLIENT_SECRET) ?: return null

  return ClientConfig(clientId, clientSecret)
}

fun loadSecretsFromEnvironment(): ClientConfig? {
  val providers = project.providers
  val envClientId = providers.environmentVariable(BAKA_CLIENT_ID).getOrNull() ?: return null
  val envClientSecret = providers.environmentVariable(BAKA_CLIENT_SECRET).getOrNull() ?: return null

  return ClientConfig(envClientId, envClientSecret)
}

fun ApplicationAndroidComponentsExtension.addSecretsToBuildConfig(clientConfig: ClientConfig) {
  val clientIdField = BuildConfigField("String", "\"${clientConfig.clientId}\"", "Client ID")
  val clientSecretField =
    BuildConfigField("String", "\"${clientConfig.clientSecret}\"", "Client Secret")

  onVariants { variant ->
    variant.buildConfigFields.put(BAKA_CLIENT_ID, clientIdField)
    variant.buildConfigFields.put(BAKA_CLIENT_SECRET, clientSecretField)
  }
}
