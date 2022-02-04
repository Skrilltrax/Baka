plugins { id("com.diffplug.spotless") }

spotless {
  kotlin {
    ktfmt().googleStyle()
    target("**/*.kt")
    targetExclude("**/build/")
  }
  kotlinGradle {
    ktfmt().googleStyle()
    target("**/*.kts")
    targetExclude("**/build/")
  }
  format("xml") {
    target("**/*.xml")
    targetExclude("**/build/", ".idea/")
    trimTrailingWhitespace()
    indentWithSpaces()
    endWithNewline()
  }
}
