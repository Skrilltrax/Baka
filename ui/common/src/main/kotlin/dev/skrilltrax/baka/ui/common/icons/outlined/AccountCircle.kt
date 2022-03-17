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

public val Icons.Outlined.AccountCircle: ImageVector
  get() {
    if (_accountCircle != null) {
      return _accountCircle!!
    }
    _accountCircle =
      materialIcon(name = "Outlined.AccountCircle") {
        materialPath {
          moveTo(12.0f, 2.0f)
          curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f)
          reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f)
          reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f)
          reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f)
          close()
          moveTo(7.07f, 18.28f)
          curveToRelative(0.43f, -0.9f, 3.05f, -1.78f, 4.93f, -1.78f)
          reflectiveCurveToRelative(4.51f, 0.88f, 4.93f, 1.78f)
          curveTo(15.57f, 19.36f, 13.86f, 20.0f, 12.0f, 20.0f)
          reflectiveCurveToRelative(-3.57f, -0.64f, -4.93f, -1.72f)
          close()
          moveTo(18.36f, 16.83f)
          curveToRelative(-1.43f, -1.74f, -4.9f, -2.33f, -6.36f, -2.33f)
          reflectiveCurveToRelative(-4.93f, 0.59f, -6.36f, 2.33f)
          curveTo(4.62f, 15.49f, 4.0f, 13.82f, 4.0f, 12.0f)
          curveToRelative(0.0f, -4.41f, 3.59f, -8.0f, 8.0f, -8.0f)
          reflectiveCurveToRelative(8.0f, 3.59f, 8.0f, 8.0f)
          curveToRelative(0.0f, 1.82f, -0.62f, 3.49f, -1.64f, 4.83f)
          close()
          moveTo(12.0f, 6.0f)
          curveToRelative(-1.94f, 0.0f, -3.5f, 1.56f, -3.5f, 3.5f)
          reflectiveCurveTo(10.06f, 13.0f, 12.0f, 13.0f)
          reflectiveCurveToRelative(3.5f, -1.56f, 3.5f, -3.5f)
          reflectiveCurveTo(13.94f, 6.0f, 12.0f, 6.0f)
          close()
          moveTo(12.0f, 11.0f)
          curveToRelative(-0.83f, 0.0f, -1.5f, -0.67f, -1.5f, -1.5f)
          reflectiveCurveTo(11.17f, 8.0f, 12.0f, 8.0f)
          reflectiveCurveToRelative(1.5f, 0.67f, 1.5f, 1.5f)
          reflectiveCurveTo(12.83f, 11.0f, 12.0f, 11.0f)
          close()
        }
      }
    return _accountCircle!!
  }

private var _accountCircle: ImageVector? = null
