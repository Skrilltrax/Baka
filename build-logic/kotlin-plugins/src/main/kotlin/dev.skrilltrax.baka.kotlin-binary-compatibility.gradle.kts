plugins { id("org.jetbrains.kotlinx.binary-compatibility-validator") }

apiValidation { ignoredProjects = mutableSetOf("app") }
