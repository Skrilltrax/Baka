import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins { id("com.google.protobuf") }

protobuf {
  protoc { artifact = "com.google.protobuf:protoc:3.19.4" }

  // Generates the java Protobuf-lite code for the Protobufs in this project. See
  // https://github.com/google/protobuf-gradle-plugin#customizing-protobuf-compilation
  // for more information.
  generateProtoTasks {
    all().forEach { task -> task.builtins.named("java").configure { option("lite") } }
  }
}
