package com.jolotan.personalwebsite

import androidx.compose.foundation.ComposeFoundationFlags
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.jolotan.personalwebsite.ui.App

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
fun main() {
    ComposeFoundationFlags.isInheritedTextStyleEnabled = true
    ComposeViewport {
        App()
    }
}