package com.jolotan.personalwebsite.ui.atoms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import coil3.compose.AsyncImage
import com.jolotan.personalwebsite.ui.theme.AppTheme
import com.jolotan.personalwebsite.ui.util.LocalCompact

private const val VIDEO_THUMBNAIL_ASPECT_RATIO = 16f / 9f

@Composable
fun VideoThumbnail(modifier: Modifier = Modifier, videoUrl: String, thumbnailUrl: Any?) {
    val uriHandler = LocalUriHandler.current

    Box(
        modifier = modifier.fillMaxWidth()
            .padding(
                horizontal = AppTheme.dimensions.getInternalContainerPadding(
                    LocalCompact.current
                )
            )
            .aspectRatio(VIDEO_THUMBNAIL_ASPECT_RATIO)
            .clip(AppTheme.shapes.extraLarge)
            .clickable(onClick = { uriHandler.openUri(videoUrl) }),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = thumbnailUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        CustomButton(
            leftIcon = Icons.Default.PlayArrow,
            onButtonClick = { uriHandler.openUri(videoUrl) })
    }
}