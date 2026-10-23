package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.styleable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.jolotan.personalwebsite.ui.atoms.CustomButton
import com.jolotan.personalwebsite.ui.theme.AppTheme
import kotlin.jvm.JvmInline

@Composable
fun DetailsSelectorComponent(
    modifier: Modifier = Modifier,
    style: Style = Style,
    isCompact: Boolean,
    detailsLabels: List<DetailsLabel>,
    selectedLabel: DetailsLabel,
    selectLabel: (DetailsLabel) -> Unit
) {
    Row(
        modifier = modifier.styleable(style = style),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.rowHorizontalSpacing)
    ) {
        val buttonModifier = Modifier.weight(1f)

        detailsLabels.forEach { label ->
            val buttonStyle = if (label == selectedLabel) {
                AppTheme.styles.button.primary
            } else {
                AppTheme.styles.button.secondary
            }

            CustomButton(
                modifier = buttonModifier,
                style = buttonStyle,
                textStyle = AppTheme.styles.text.largeButtonText,
                text = if (isCompact) null else label.text,
                leftIcon = label.icon,
                iconContentDescription = label.text,
                onButtonClick = { selectLabel(label) }
            )
        }
    }
}

@JvmInline
data class DetailsLabel(val icon: ImageVector, val text: String)
