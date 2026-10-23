package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.style.then
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jolotan.personalwebsite.ui.atoms.StyledText
import com.jolotan.personalwebsite.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import personalwebsite.shared.generated.resources.Res
import personalwebsite.shared.generated.resources.site_headshot

@Composable
fun IntroductionComponent(modifier: Modifier = Modifier, style: Style = Style, isCompact: Boolean) {
    if (isCompact) {
        Column(
            modifier = modifier.styleable(style = style then Style {
                textAlign(TextAlign.Center)
            }),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
        ) {
            IntroductionComponentImage(modifier = Modifier.width(200.dp))
            IntroductionComponentDetails(modifier = Modifier.fillMaxWidth())
        }
    } else {
        Row(
            modifier = modifier.styleable(style = style),
            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.rowHorizontalSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IntroductionComponentDetails(modifier = Modifier.weight(5f))
            IntroductionComponentImage(modifier = Modifier.height(320.dp))
        }
    }
}

@Composable
fun IntroductionComponentDetails(modifier: Modifier = Modifier, style: Style = Style) {
    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
    ) {
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            text = "Hello, I'm Jolo!",
            style = AppTheme.styles.text.primaryText
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.columnVerticalSpacing))
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            text = "I turn ideas into polished apps for Android and beyond with Kotlin Multiplatform.",
            style = AppTheme.styles.text.sectionText then AppTheme.styles.text.headlineText
        )
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            text = "(Even this site is written in Kotlin Multiplatform!)",
            style = AppTheme.styles.text.helperText
        )
    }
}

@Composable
fun IntroductionComponentImage(modifier: Modifier = Modifier, style: Style = Style) {
    Image(
        modifier = modifier.aspectRatio(1f)
            .clip(shape = CircleShape)
            .styleable(style = style),
        painter = painterResource(Res.drawable.site_headshot),
        contentDescription = null
    )
}