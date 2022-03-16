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

public val Icons.Filled.AccountCircle: ImageVector
  get() {
    if (_accountCircle != null) {
      return _accountCircle!!
    }
    _accountCircle =
      materialIcon(name = "Filled.AccountCircle.kt") {
        materialPath {
          moveTo(12.0f, 2.0f)
          curveTo(6.48f, 2.0f, 2.0f, 6.48f, 2.0f, 12.0f)
          reflectiveCurveToRelative(4.48f, 10.0f, 10.0f, 10.0f)
          reflectiveCurveToRelative(10.0f, -4.48f, 10.0f, -10.0f)
          reflectiveCurveTo(17.52f, 2.0f, 12.0f, 2.0f)
          close()
          moveTo(12.0f, 5.0f)
          curveToRelative(1.66f, 0.0f, 3.0f, 1.34f, 3.0f, 3.0f)
          reflectiveCurveToRelative(-1.34f, 3.0f, -3.0f, 3.0f)
          reflectiveCurveToRelative(-3.0f, -1.34f, -3.0f, -3.0f)
          reflectiveCurveToRelative(1.34f, -3.0f, 3.0f, -3.0f)
          close()
          moveTo(12.0f, 19.2f)
          curveToRelative(-2.5f, 0.0f, -4.71f, -1.28f, -6.0f, -3.22f)
          curveToRelative(0.03f, -1.99f, 4.0f, -3.08f, 6.0f, -3.08f)
          curveToRelative(1.99f, 0.0f, 5.97f, 1.09f, 6.0f, 3.08f)
          curveToRelative(-1.29f, 1.94f, -3.5f, 3.22f, -6.0f, 3.22f)
          close()
        }
      }
    return _accountCircle!!
  }

private var _accountCircle: ImageVector? = null
