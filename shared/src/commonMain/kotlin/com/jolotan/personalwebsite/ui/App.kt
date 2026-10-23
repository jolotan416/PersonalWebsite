package com.jolotan.personalwebsite.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.style.styleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.WorkHistory
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfoV2
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.window.core.layout.WindowSizeClass
import com.jolotan.personalwebsite.ui.atoms.TimedAnimatedVisibility
import com.jolotan.personalwebsite.ui.molecules.DetailsLabel
import com.jolotan.personalwebsite.ui.molecules.DetailsSelectorComponent
import com.jolotan.personalwebsite.ui.molecules.IntroductionComponent
import com.jolotan.personalwebsite.ui.theme.AppTheme
import kotlin.time.Duration.Companion.milliseconds

private val DETAILS_LABELS =
    listOf(
        DetailsLabel(icon = Icons.Default.Psychology, text = "Skills"),
        DetailsLabel(icon = Icons.Default.WorkHistory, text = "Experience"),
        DetailsLabel(icon = Icons.Outlined.Code, text = "Projects")
    )

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
                Modifier.widthIn(max = AppTheme.dimensions.maxSectionWidth)
            }
        var selectedDetails by remember { mutableStateOf(DETAILS_LABELS.first()) }

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
            item(key = Unit) {
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

            stickyHeader(key = selectedDetails) {
                DetailsSelectorComponent(
                    modifier = widthModifier,
                    detailsLabels = DETAILS_LABELS,
                    isCompact = isCompact,
                    selectedLabel = selectedDetails,
                    selectLabel = { selectedDetails = it }
                )
            }
        }
    }
}