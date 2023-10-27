import com.android.build.gradle.TestedExtension

extensions.configure<TestedExtension> {
  setCompileSdkVersion(34)
  defaultConfig {
    minSdk = 23
    targetSdk = 34
  }

  sourceSets {
    named("main") { java.srcDirs("src/main/kotlin") }
    named("test") { java.srcDirs("src/test/kotlin") }
    named("androidTest") { java.srcDirs("src/androidTest/kotlin") }
  }

  packagingOptions {
    resources.excludes.add("**/*.version")
    resources.excludes.add("**/*.txt")
    resources.excludes.add("**/*.kotlin_module")
    resources.excludes.add("**/plugin.properties")
    resources.excludes.add("**/META-INF/AL2.0")
    resources.excludes.add("**/META-INF/LGPL2.1")
  }

  compileOptions {
    isCoreLibraryDesugaringEnabled = true
    sourceCompatibility = JavaVersion.VERSION_19
    targetCompatibility = JavaVersion.VERSION_19
  }

  testOptions {
    animationsDisabled = true
    unitTests.isReturnDefaultValues = true
  }
}

dependencies { "coreLibraryDesugaring"(libs.findLibrary("build.corelibdesugar").get()) }
