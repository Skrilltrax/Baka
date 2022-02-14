import com.android.build.api.variant.BuildConfigField
import java.util.Properties
import secrets.Constants.BAKA_CLIENT_ID
import secrets.Constants.BAKA_CLIENT_SECRET
import secrets.Constants.SECRETS_PROP_FILE

plugins { id("com.android.application") }

androidComponents {
  val projectDirectory = project.layout.projectDirectory
  val providers = project.providers
  val propFile = projectDirectory.file(SECRETS_PROP_FILE)
  require(propFile.asFile.exists()) {
    "A 'secrets.properties' file must exist in the project subdirectory to use this plugin"
  }
  val contents = providers.fileContents(propFile).asText
  val secretsProps = Properties().also { it.load(contents.get().byteInputStream()) }
      val clientId =
        requireNotNull(secretsProps.getProperty(BAKA_CLIENT_ID)) {
          "secrets.properties must contain a '$BAKA_CLIENT_ID' property"
        }
      val clientSecret =
        requireNotNull(secretsProps.getProperty(BAKA_CLIENT_SECRET)) {
          "secrets.properties must contain a '$BAKA_CLIENT_SECRET' property"
        }
  onVariants { variant ->
    variant.buildConfigFields.put(BAKA_CLIENT_ID, BuildConfigField("String", "\"$clientId\"", "Client ID"))
    variant.buildConfigFields.put(BAKA_CLIENT_SECRET, BuildConfigField("String", "\"$clientSecret\"", "Client Secret"))
  }
}
