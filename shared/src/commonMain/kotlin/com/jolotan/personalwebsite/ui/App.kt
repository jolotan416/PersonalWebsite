package com.jolotan.personalwebsite.ui

import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jolotan.personalwebsite.ui.theme.AppTheme

@OptIn(ExperimentalFoundationStyleApi::class)
@Composable
@Preview
fun App() {
    AppTheme {
        BasicText(
            modifier = Modifier.styleable(style = AppTheme.styles.text.headerText),
            text = "Hello World!!!!"
        )
    }
}