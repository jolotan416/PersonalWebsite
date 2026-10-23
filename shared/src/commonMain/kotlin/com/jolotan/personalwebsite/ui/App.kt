package com.jolotan.personalwebsite.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.style.styleable
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import com.jolotan.personalwebsite.ui.atoms.TimedAnimatedVisibility
import com.jolotan.personalwebsite.ui.molecules.IntroductionComponent
import com.jolotan.personalwebsite.ui.theme.AppTheme
import kotlin.time.Duration.Companion.milliseconds

@OptIn(ExperimentalFoundationStyleApi::class)
@Composable
fun App(windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfoV2().windowSizeClass) {
    AppTheme {
        val isCompact =
            !windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_LARGE_LOWER_BOUND)
        val widthModifier =
            if (isCompact) {
                Modifier.fillMaxWidth()
            } else {
                Modifier.widthIn(max = 1000.dp)
            }

        LazyColumn(
            modifier = Modifier.fillMaxSize()
                .styleable(style = AppTheme.styles.container.main),
            verticalArrangement = Arrangement.spacedBy(
                space = AppTheme.dimensions.columnVerticalSpacing,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(AppTheme.dimensions.mainContainerPadding)
        ) {
            item {
                TimedAnimatedVisibility(
                    modifier = widthModifier,
                    duration = 250.milliseconds
                ) {
                    IntroductionComponent(
                        modifier = Modifier.fillMaxWidth(),
                        style = AppTheme.styles.container.section,
                        isCompact = isCompact
                    )
                }
            }
        }
    }
}