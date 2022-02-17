package dev.skrilltrax.baka.core.auth

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

internal object AuthSerializer : Serializer<Auth> {

  override val defaultValue: Auth
    get() = Auth.getDefaultInstance()

  override suspend fun readFrom(input: InputStream): Auth {
    try {
      return Auth.parseFrom(input)
    } catch (exception: InvalidProtocolBufferException) {
      throw CorruptionException("Cannot read proto.", exception)
    }
  }

  override suspend fun writeTo(t: Auth, output: OutputStream) {
    t.writeTo(output)
  }
}
