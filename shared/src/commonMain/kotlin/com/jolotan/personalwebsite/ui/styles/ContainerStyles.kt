package com.jolotan.personalwebsite.ui.styles

import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.contentPadding
import com.jolotan.personalwebsite.ui.theme.AppTheme

object ContainerStyles {
    val main = Style {
        background(color = colors.background)
        contentColor(value = colors.onBackground)
    }

    fun getStyleSection(isCompact: Boolean) = Style {
        shape(shapes.medium)
        background(colors.surfaceContainer)
        contentColor(colors.onSurface)
        contentPadding(AppTheme.dimensions.getInternalContainerPadding(isCompact))
    }
}