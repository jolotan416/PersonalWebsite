package com.jolotan.personalwebsite.ui.styles

import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.style.Style

@OptIn(ExperimentalFoundationStyleApi::class)
object TextStyles {
    val headerText = Style {
        textStyle(typography.headlineLarge)
        contentColor(colors.primary)
    }
}