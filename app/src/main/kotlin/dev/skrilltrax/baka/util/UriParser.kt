package dev.skrilltrax.baka.util

import android.net.Uri

class UriParser(private val uri: Uri) {

  fun getParameters(): Map<String, String> {
    val map = mutableMapOf<String, String>()
    val fragment = uri.fragment ?: return map

    val keyValueParts = fragment.split('&')

    keyValueParts.forEach { keyValueString ->
      val keyValueList = keyValueString.split('=')
      if (keyValueList.size != 2) return@forEach

      map[keyValueList.first()] = keyValueList.last()
    }

    return map
  }
}
