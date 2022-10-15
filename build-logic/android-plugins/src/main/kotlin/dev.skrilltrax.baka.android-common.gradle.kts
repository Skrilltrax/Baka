import com.android.build.gradle.TestedExtension

extensions.configure<TestedExtension> {
  setCompileSdkVersion(33)
  defaultConfig {
    minSdk = 23
    targetSdk = 33
  }

  sourceSets {
    named("main") { java.srcDirs("src/main/kotlin") }
    named("test") { java.srcDirs("src/test/kotlin") }
    named("androidTest") { java.srcDirs("src/androidTest/kotlin") }
  }

  @Suppress("UnstableApiUsage")
  packagingOptions {
    resources.excludes.add("**/*.version")
    resources.excludes.add("**/*.txt")
    resources.excludes.add("**/*.kotlin_module")
    resources.excludes.add("**/plugin.properties")
    resources.excludes.add("**/META-INF/AL2.0")
    resources.excludes.add("**/META-INF/LGPL2.1")
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  testOptions {
    animationsDisabled = true
    unitTests.isReturnDefaultValues = true
  }
}
