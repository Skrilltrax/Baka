import com.android.build.gradle.TestedExtension
import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins { id("com.google.protobuf") }

protobuf {
  protoc { artifact = "com.google.protobuf:protoc:3.19.4" }

  val sourceSetExtension = project.getSourceSetExtension()
  sourceSetExtension?.apply {
    named("main") { java.srcDirs("build/generated/source/proto/main/java") }
    named("test") { java.srcDirs("build/generated/source/proto/main/java") }

    named("main") { java.srcDirs("build/generated/source/proto/main/kotlin") }
    named("test") { java.srcDirs("build/generated/source/proto/main/kotlin") }
  }

  val androidExtension = project.getAndroidExtension()
  androidExtension?.sourceSets {
    named("main") { java.srcDirs("build/generated/source/proto/main/java") }
    named("test") { java.srcDirs("build/generated/source/proto/main/java") }
    named("androidTest") { java.srcDirs("build/generated/source/proto/main/java") }

    named("main") { java.srcDirs("build/generated/source/proto/main/kotlin") }
    named("test") { java.srcDirs("build/generated/source/proto/main/kotlin") }
    named("androidTest") { java.srcDirs("build/generated/source/proto/main/kotlin") }
  }

  // Generates the java Protobuf-lite code for the Protobufs in this project. See
  // https://github.com/google/protobuf-gradle-plugin#customizing-protobuf-compilation
  // for more information.
  generateProtoTasks {
    all().forEach { task ->
      task.builtins.named("java").configure { option("lite") }
      task.builtins.create("kotlin").option("lite")
    }
  }
}

fun Project.getAndroidExtension() = extensions.findByType<TestedExtension>()

fun Project.getSourceSetExtension() = extensions.findByType<SourceSetContainer>()
