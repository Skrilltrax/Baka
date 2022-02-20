package dev.skrilltrax.baka.util

import android.net.Uri

/**
 * Returns a [Map] of parameters present after the fragment of a [Uri] object.
 *
 * Example: If a [Uri] is of kind https://example.com#token=abc123&expires_in=12345678 the method
 * would return a [Map] like the following: { token: abc123, expires_in: 12345678 }
 */
fun Uri.getParameters(): Map<String, String> {
  val map = mutableMapOf<String, String>()
  val fragment = fragment ?: return map

  val keyValueParts = fragment.split('&')

  keyValueParts.forEach { keyValueString ->
    val keyValueList = keyValueString.split('=')
    if (keyValueList.size != 2) return@forEach

    map[keyValueList.first()] = keyValueList.last()
  }

  return map
}
