package com.jolotan.personalwebsite.ui.atoms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlin.time.Duration

@Composable
fun TimedAnimatedVisibility(
    modifier: Modifier = Modifier,
    duration: Duration,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    var visible by remember { mutableStateOf(false) }

    AnimatedVisibility(modifier = modifier, visible = visible, content = content)

    LaunchedEffect(Unit) {
        delay(duration)
        visible = true
    }
}