package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.styleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.jolotan.personalwebsite.ui.theme.AppTheme
import com.jolotan.personalwebsite.ui.util.LocalCompact
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ImageRow(modifier: Modifier = Modifier, style: Style = Style, images: List<DrawableResource>) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { images.size })
    Column(modifier = modifier.styleable(style = style)) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (!LocalCompact.current) {
                IconButton(onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBackIosNew,
                        contentDescription = null,
                        tint = AppTheme.colors.onSurface
                    )
                }
            }

            HorizontalPager(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(horizontal = AppTheme.dimensions.imageElevation),
                state = pagerState,
                pageSize = PageSize.Fixed(200.dp),
                pageSpacing = AppTheme.dimensions.rowHorizontalSpacing
            ) { page ->
                Image(
                    modifier = Modifier.fillMaxWidth()
                        .shadow(
                            elevation = AppTheme.dimensions.imageElevation,
                            shape = AppTheme.shapes.extraLarge
                        ),
                    painter = painterResource(images[page]),
                    contentDescription = null
                )
            }

            if (!LocalCompact.current) {
                IconButton(onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
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