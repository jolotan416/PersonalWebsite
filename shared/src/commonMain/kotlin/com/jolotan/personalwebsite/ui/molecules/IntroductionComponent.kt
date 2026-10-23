package com.jolotan.personalwebsite.ui.molecules

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.style.then
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import com.jolotan.personalwebsite.ui.atoms.StyledText
import com.jolotan.personalwebsite.ui.theme.AppTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import personalwebsite.shared.generated.resources.Res
import personalwebsite.shared.generated.resources.github
import personalwebsite.shared.generated.resources.instagram
import personalwebsite.shared.generated.resources.linkedin
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
            IntroductionComponentImage(modifier = Modifier.width(AppTheme.dimensions.compactImageWidth))
            IntroductionComponentDetails(modifier = Modifier.fillMaxWidth(), isCompact = true)
        }
    } else {
        Row(
            modifier = modifier.styleable(style = style),
            horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.rowHorizontalSpacing),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IntroductionComponentDetails(modifier = Modifier.weight(5f), isCompact = false)
            IntroductionComponentImage(modifier = Modifier.width(AppTheme.dimensions.imageWidth))
        }
    }
}

@Composable
fun IntroductionComponentDetails(
    modifier: Modifier = Modifier,
    style: Style = Style,
    isCompact: Boolean
) {
    Column(
        modifier = modifier.styleable(style = style),
        verticalArrangement = Arrangement.spacedBy(AppTheme.dimensions.columnVerticalSpacing)
    ) {
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            text = "Hello, I'm Jolo!",
            style = AppTheme.styles.text.primaryText
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.columnSmallVerticalSpacing))
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            text = "I turn ideas into polished apps for Android and beyond with Kotlin Multiplatform.",
            style = AppTheme.styles.text.sectionText then AppTheme.styles.text.headlineText
        )
        StyledText(
            modifier = Modifier.fillMaxWidth(),
            text = "(Fun fact: Even this site is written in Kotlin Multiplatform.)",
            style = AppTheme.styles.text.helperText
        )
        Spacer(modifier = Modifier.height(AppTheme.dimensions.columnSmallVerticalSpacing))
        IntroductionComponentSocialMediaButtons(
            modifier = Modifier.fillMaxWidth(),
            isCompact = isCompact
        )
    }
}

@Composable
fun IntroductionComponentSocialMediaButtons(
    modifier: Modifier = Modifier,
    style: Style = Style,
    isCompact: Boolean
) {
    val uriHandler = LocalUriHandler.current
    val socialMediaButtons = listOf(
        SocialMediaButton(
            icon = SocialMediaIcon.Drawable(Res.drawable.github),
            url = "https://github.com/jolotan416"
        ),
        SocialMediaButton(
            icon = SocialMediaIcon.Drawable(Res.drawable.linkedin),
            url = "https://www.linkedin.com/in/john-louise-tan-b76704123"
        ),
        SocialMediaButton(
            icon = SocialMediaIcon.Drawable(Res.drawable.instagram),
            url = "https://www.instagram.com/sabaw.builds/"
        ),
        SocialMediaButton(
            icon = SocialMediaIcon.Vector(Icons.Default.Email),
            url = "mailto:jolotan416@gmail.com"
        ),
        SocialMediaButton(
            icon = SocialMediaIcon.Vector(Icons.Default.Phone),
            url = "tel:+4915259824225"
        )
    )

    Row(
        modifier = modifier.styleable(style = style),
        horizontalArrangement = Arrangement.spacedBy(
            space = AppTheme.dimensions.rowHorizontalSpacing,
            alignment = if (isCompact) Alignment.CenterHorizontally else Alignment.Start
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        socialMediaButtons.forEach { (icon, url) ->
            val iconModifier = Modifier.size(AppTheme.dimensions.iconSize)
                .clickable(onClick = { uriHandler.openUri(url) })
            val iconTint = AppTheme.colors.onSurface

            when (icon) {
                is SocialMediaIcon.Drawable -> {
                    Icon(
                        modifier = iconModifier,
                        painter = painterResource(icon.drawableResource),
                        tint = iconTint,
                        contentDescription = null
                    )
                }

                is SocialMediaIcon.Vector -> {
                    Icon(
                        modifier = iconModifier,
                        imageVector = icon.imageVector,
                        tint = iconTint,
                        contentDescription = null
                    )
                }
            }
        }
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

data class SocialMediaButton(
    val icon: SocialMediaIcon,
    val url: String
)

sealed interface SocialMediaIcon {
    data class Drawable(val drawableResource: DrawableResource) : SocialMediaIcon
    data class Vector(val imageVector: ImageVector) : SocialMediaIcon
}