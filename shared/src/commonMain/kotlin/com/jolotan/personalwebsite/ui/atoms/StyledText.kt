package com.jolotan.personalwebsite.ui.atoms

import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.StyleState
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import com.jolotan.personalwebsite.ui.styles.rememberResolvedTextStyle
import com.jolotan.personalwebsite.ui.styles.rememberThemedStyle
import com.jolotan.personalwebsite.ui.theme.AppTheme

@Composable
fun StyledText(
    text: String,
    modifier: Modifier = Modifier,
    style: Style = Style,
    styleState: StyleState? = null,
    textStyle: TextStyle = TextStyle.Default,
    color: ColorProducer? = null,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    minLines: Int = 1,
) {
    key(text) {
        val themedStyle = rememberThemedStyle(style)
        // Selectable text (inside a SelectionContainer) ignores the text properties applied by
        // Modifier.styleable, so pass the resolved text style to BasicText explicitly.
        val resolvedTextStyle = rememberResolvedTextStyle(themedStyle, styleState).value
            .merge(textStyle)
        val fallbackColor = AppTheme.colors.onSurface

        BasicText(
            text = text,
            modifier = modifier.styleable(styleState = styleState, style = themedStyle),
            style = resolvedTextStyle,
            color = color ?: ColorProducer { resolvedTextStyle.color.takeOrElse { fallbackColor } },
            overflow = overflow,
            softWrap = softWrap,
            maxLines = maxLines,
            minLines = minLines,
        )
    }
}
