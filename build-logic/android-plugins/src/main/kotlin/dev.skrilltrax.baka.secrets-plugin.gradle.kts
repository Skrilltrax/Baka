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
  val propResult = kotlin.runCatching { loadSecretsFromProperties(projectDirectory) }
  if (propResult.isSuccess) {
    addSecretsToBuildConfig(propResult.getOrThrow())
  }
  val envResult = kotlin.runCatching { loadSecretsFromEnvironment() }
  if (envResult.isSuccess) {
    addSecretsToBuildConfig(envResult.getOrThrow())
  }
}

fun loadSecretsFromProperties(projectDirectory: Directory): ClientConfig {
  val providers = project.providers
  val secretsFile = projectDirectory.file(SECRETS_PROP_FILE)

  checkNotNull(secretsFile.asFile.exists()) {
    "A 'secrets.properties' file must exist in the project subdirectory to use this plugin"
  }
  val contents = providers.fileContents(secretsFile).asText
  val secretProps = Properties().also { it.load(contents.get().byteInputStream()) }
  val clientId =
    checkNotNull(secretProps.getProperty(BAKA_CLIENT_ID)) {
      "secrets.properties must contain a '$BAKA_CLIENT_ID' property"
    }
  val clientSecret =
    checkNotNull(secretProps.getProperty(BAKA_CLIENT_SECRET)) {
      "secrets.properties must contain a '$BAKA_CLIENT_SECRET' property"
    }

  return ClientConfig(clientId, clientSecret)
}

fun loadSecretsFromEnvironment(): ClientConfig {
  val providers = project.providers
  val envClientId = providers.environmentVariable(BAKA_CLIENT_ID).get()
  val envClientSecret = providers.environmentVariable(BAKA_CLIENT_SECRET).get()

  checkNotNull(envClientId) { "environment variable must contain a '$BAKA_CLIENT_ID' property" }

  checkNotNull(envClientSecret) {
    "environment variable must contain a '$BAKA_CLIENT_SECRET' property"
  }

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
