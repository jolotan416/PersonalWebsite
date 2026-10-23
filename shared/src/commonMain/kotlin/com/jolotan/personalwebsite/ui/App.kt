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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.window.core.layout.WindowSizeClass
import com.jolotan.personalwebsite.ui.atoms.StyledText
import com.jolotan.personalwebsite.ui.atoms.TimedAnimatedVisibility
import com.jolotan.personalwebsite.ui.molecules.DetailsComponent
import com.jolotan.personalwebsite.ui.molecules.DetailsSection
import com.jolotan.personalwebsite.ui.molecules.DetailsSelectorComponent
import com.jolotan.personalwebsite.ui.molecules.IntroductionComponent
import com.jolotan.personalwebsite.ui.molecules.SectionTextStyle
import com.jolotan.personalwebsite.ui.theme.AppTheme
import com.jolotan.personalwebsite.ui.util.DetailsType
import com.jolotan.personalwebsite.ui.util.LocalCompact
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
                Modifier.widthIn(max = AppTheme.dimensions.maxSectionWidth)
            }
        var isAnimatedVisibilityFinished by remember { mutableStateOf(false) }
        var isDetailsVisible by remember { mutableStateOf(false) }
        var selectedDetailsType by remember { mutableStateOf(DetailsType.entries.first()) }

        CompositionLocalProvider(LocalCompact provides isCompact) {
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
                        key = Unit,
                        duration = 100.milliseconds,
                        isVisible = isAnimatedVisibilityFinished,
                        updateVisibility = { isAnimatedVisibilityFinished = it }
                    ) {
                        IntroductionComponent(
                            modifier = Modifier.fillMaxWidth(),
                            style = AppTheme.styles.container.section,
                        )
                    }
                }

                item {
                    TimedAnimatedVisibility(
                        modifier = widthModifier,
                        key = Unit,
                        duration = 100.milliseconds,
                        isVisible = isAnimatedVisibilityFinished,
                        updateVisibility = { isAnimatedVisibilityFinished = it }
                    ) {
                        DetailsSection(modifier = Modifier.fillMaxWidth(), title = "About me") {
                            StyledText(
                                modifier = Modifier.fillMaxWidth(),
                                style = SectionTextStyle(),
                                text = """
                                I'm a mobile developer specializing in Android development and Kotlin Multiplatform. I care about improving user experiences through clean architecture, well-tested code, and polished user interfaces. I love tinkering with new ideas and concepts for building products both inside and outside of the codebase.
                                
                                Today, I'm working as a Senior Android Developer at Paradox Cat GmbH in Germany, where I've contributed to multiple projects and use cases spanning various in-car experiences like real-time car signals, call handling, video playback, and backend communication over MQTT and REST.
                                
                                Before entering the automotive industry, I spent nearly three years building and leading features for BeautyMnl, one of the Philippines' homegrown e-commerce platforms. My engineering foundation was built at Nokia, where I wrote 5G network simulators using C++ and grew into a technical lead role.
                                
                                Across every role, from telecom to e-commerce to automotive, my philosophy has been the same. It's to always leave the places I've worked in better than I found them.
                            """.trimIndent()
                            )
                        }
                    }
                }

                stickyHeader(key = selectedDetailsType.buttonText) {
                    TimedAnimatedVisibility(
                        modifier = widthModifier,
                        key = Unit,
                        duration = 100.milliseconds,
                        isVisible = isAnimatedVisibilityFinished,
                        updateVisibility = { isAnimatedVisibilityFinished = it }
                    ) {
                        DetailsSelectorComponent(
                            modifier = widthModifier,
                            selectedDetailsType = selectedDetailsType,
                            selectLabel = {
                                isDetailsVisible = false
                                selectedDetailsType = it
                            }
                        )
                    }
                }

                item(key = selectedDetailsType) {
                    TimedAnimatedVisibility(
                        modifier = widthModifier,
                        key = selectedDetailsType,
                        duration = 50.milliseconds,
                        isVisible = isDetailsVisible,
                        updateVisibility = { isDetailsVisible = it }
                    ) {
                        DetailsComponent(
                            modifier = Modifier.fillMaxWidth(),
                            detailsType = selectedDetailsType
                        )
                    }
                }
            }
        }
    }
}