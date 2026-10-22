@file:OptIn(ExperimentalFoundationStyleApi::class)

package com.jolotan.personalwebsite.ui.styles

import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.style.StyleScope
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import com.jolotan.personalwebsite.ui.Dimensions
import com.jolotan.personalwebsite.ui.theme.AppTheme
import com.jolotan.personalwebsite.ui.theme.AppTheme.Companion.LocalAppTheme

val StyleScope.colors: ColorScheme
    get() = LocalAppTheme.currentValue.colors

val StyleScope.typography: Typography
    get() = LocalAppTheme.currentValue.typography

val StyleScope.shapes: Shapes
    get() = LocalAppTheme.currentValue.shapes

val StyleScope.dimensions: Dimensions
    get() = AppTheme.dimensions