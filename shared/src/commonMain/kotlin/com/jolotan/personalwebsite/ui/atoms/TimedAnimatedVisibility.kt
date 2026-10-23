package com.jolotan.personalwebsite.ui.atoms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlin.time.Duration

@Composable
fun TimedAnimatedVisibility(
    modifier: Modifier = Modifier,
    key: Any?,
    duration: Duration,
    isVisible: Boolean,
    updateVisibility: (Boolean) -> Unit,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(modifier = modifier, visible = isVisible, content = content)

    LaunchedEffect(key) {
        delay(duration)
        updateVisibility(true)
    }
}