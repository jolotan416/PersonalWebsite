package com.jolotan.personalwebsite.ui.styles

import androidx.compose.foundation.style.Style
import androidx.compose.ui.text.style.TextAlign

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

    // Buton text styles
    val buttonText = Style {
        textStyle(typography.labelLarge)
        textAlign(TextAlign.Center)
    }

    val largeButtonText = Style {
        textStyle(typography.headlineSmall)
    }
}