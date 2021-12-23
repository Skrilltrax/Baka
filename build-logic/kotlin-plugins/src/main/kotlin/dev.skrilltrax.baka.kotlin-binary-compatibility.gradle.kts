import kotlinx.validation.ApiValidationExtension
import org.gradle.kotlin.dsl.configure

plugins { id("org.jetbrains.kotlinx.binary-compatibility-validator") }

extensions.configure<ApiValidationExtension> { ignoredProjects = mutableSetOf("app") }
