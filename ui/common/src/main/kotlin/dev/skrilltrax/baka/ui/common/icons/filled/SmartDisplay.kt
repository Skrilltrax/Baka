/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.skrilltrax.baka.ui.common.icons.filled

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

val Icons.Filled.SmartDisplay: ImageVector
  get() {
    if (_smartDisplay != null) {
      return _smartDisplay!!
    }
    _smartDisplay =
      materialIcon(name = "Filled.SmartDisplay") {
        materialPath {
          moveTo(20.0f, 4.0f)
          horizontalLineTo(4.0f)
          curveTo(2.9f, 4.0f, 2.0f, 4.9f, 2.0f, 6.0f)
          verticalLineToRelative(12.0f)
          curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
          horizontalLineToRelative(16.0f)
          curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f)
          verticalLineTo(6.0f)
          curveTo(22.0f, 4.9f, 21.1f, 4.0f, 20.0f, 4.0f)
          close()
          moveTo(9.5f, 16.5f)
          verticalLineToRelative(-9.0f)
          lineToRelative(7.0f, 4.5f)
          lineTo(9.5f, 16.5f)
          close()
        }
      }
    return _smartDisplay!!
  }

private var _smartDisplay: ImageVector? = null
