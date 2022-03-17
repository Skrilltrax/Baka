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

package dev.skrilltrax.baka.ui.common.icons.outlined

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.materialPath
import androidx.compose.ui.graphics.vector.ImageVector

public val Icons.Outlined.Search: ImageVector
  get() {
    if (_search != null) {
      return _search!!
    }
    _search =
      materialIcon(name = "Outlined.Search") {
        materialPath {
          moveTo(15.5f, 14.0f)
          horizontalLineToRelative(-0.79f)
          lineToRelative(-0.28f, -0.27f)
          curveTo(15.41f, 12.59f, 16.0f, 11.11f, 16.0f, 9.5f)
          curveTo(16.0f, 5.91f, 13.09f, 3.0f, 9.5f, 3.0f)
          reflectiveCurveTo(3.0f, 5.91f, 3.0f, 9.5f)
          reflectiveCurveTo(5.91f, 16.0f, 9.5f, 16.0f)
          curveToRelative(1.61f, 0.0f, 3.09f, -0.59f, 4.23f, -1.57f)
          lineToRelative(0.27f, 0.28f)
          verticalLineToRelative(0.79f)
          lineToRelative(5.0f, 4.99f)
          lineTo(20.49f, 19.0f)
          lineToRelative(-4.99f, -5.0f)
          close()
          moveTo(9.5f, 14.0f)
          curveTo(7.01f, 14.0f, 5.0f, 11.99f, 5.0f, 9.5f)
          reflectiveCurveTo(7.01f, 5.0f, 9.5f, 5.0f)
          reflectiveCurveTo(14.0f, 7.01f, 14.0f, 9.5f)
          reflectiveCurveTo(11.99f, 14.0f, 9.5f, 14.0f)
          close()
        }
      }
    return _search!!
  }

private var _search: ImageVector? = null
