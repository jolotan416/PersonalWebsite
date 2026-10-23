package com.jolotan.personalwebsite.ui.styles

import androidx.compose.foundation.style.Style

object TextStyles {
    val primaryText = Style {
        textStyle(typography.displayLargeEmphasized)
        contentColor(colors.primary)
    }

    val headlineText = Style {
        textStyle(typography.headlineMedium)
    }

    val helperText = Style {
        textStyle(typography.bodyMediumEmphasized)
    }

    val sectionText = Style {
        contentColor(colors.onSurface)
    }
}