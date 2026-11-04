package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.jolotan.personalwebsite.ui.atoms.StyledText
import com.jolotan.personalwebsite.ui.theme.AppTheme
import com.jolotan.personalwebsite.ui.util.LocalCompact
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

private const val ICON_BUTTON_ALPHA = 0.75f

@Composable
fun ImageDialog(
    images: List<DrawableResource>,
    selectedIndex: Int,
    onDismiss: () -> Unit
) {
    var selectedImageIndex by remember(selectedIndex) { mutableStateOf(selectedIndex) }

    Dialog(onDismissRequest = onDismiss) {
        Box(contentAlignment = Alignment.Center) {
            if (LocalCompact.current) {
                ImageDialogColumn(
                    modifier = Modifier.fillMaxHeight(),
                    image = images[selectedImageIndex],
                    onDismiss = onDismiss
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    colors = IconButtonColors(
                        containerColor = AppTheme.colors.surface.copy(alpha = ICON_BUTTON_ALPHA),
                        contentColor = AppTheme.colors.onSurface.copy(alpha = ICON_BUTTON_ALPHA),
                        disabledContainerColor = AppTheme.colors.surfaceVariant.copy(alpha = ICON_BUTTON_ALPHA),
                        disabledContentColor = AppTheme.colors.onSurfaceVariant.copy(alpha = ICON_BUTTON_ALPHA)
                    ),
                    enabled = selectedImageIndex > 0,
                    onClick = {
                        if (selectedImageIndex > 0) {
                            --selectedImageIndex
                        }
                    }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = null,
                        tint = AppTheme.colors.onSurface
                    )
                }

                if (!LocalCompact.current) {
                    ImageDialogColumn(
                        modifier = Modifier.weight(1f),
                        image = images[selectedImageIndex],
                        onDismiss = onDismiss
                    )
                }

                IconButton(
                    colors = IconButtonColors(
                        containerColor = AppTheme.colors.surface.copy(alpha = ICON_BUTTON_ALPHA),
                        contentColor = AppTheme.colors.onSurface.copy(alpha = ICON_BUTTON_ALPHA),
                        disabledContainerColor = AppTheme.colors.surfaceVariant.copy(alpha = ICON_BUTTON_ALPHA),
                        disabledContentColor = AppTheme.colors.onSurfaceVariant.copy(alpha = ICON_BUTTON_ALPHA)
                    ),
                    enabled = selectedImageIndex < images.lastIndex,
                    onClick = {
                        if (selectedImageIndex < images.lastIndex) {
                            ++selectedImageIndex
                        }
                    }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowForwardIos,
                        contentDescription = null,
                        tint = AppTheme.colors.onSurface
                    )
                }
            }
        }
    }
}

@Composable
fun ImageDialogColumn(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    onDismiss: () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = AppTheme.dimensions.getColumnVerticalSpacing(LocalCompact.current),
            alignment = Alignment.CenterVertically
        )
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null
        )
        TextButton(onClick = onDismiss) {
            StyledText(style = AppTheme.styles.text.bodyText, text = "Close")
        }
    }
}