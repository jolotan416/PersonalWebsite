package com.jolotan.personalwebsite.ui.styles

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.style.ExperimentalFoundationStyleApi
import androidx.compose.foundation.style.MutableStyleState
import androidx.compose.foundation.style.Style
import androidx.compose.foundation.style.StyleScope
import androidx.compose.foundation.style.StyleState
import androidx.compose.foundation.style.StyleStateKey
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalMap
import androidx.compose.runtime.State
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.isSpecified
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.isSpecified
import com.jolotan.personalwebsite.ui.theme.AppTheme.Companion.LocalAppTheme

/**
 * Resolves the text-related properties of a [Style] into a plain [TextStyle]. This is a workaround
 * to support text selection in the current experimental version of the Styles API.
 *
 * Text rendered inside a `SelectionContainer` goes through a selectable text node that ignores the
 * text properties applied by `Modifier.styleable`, so they must be passed to `BasicText`
 * explicitly. Non-text properties (padding, background, shape, ...) are ignored here because
 * `styleable` still applies them.
 *
 * Note: properties inherited from ancestor `styleable` containers are not visible here.
 */
@OptIn(ExperimentalFoundationStyleApi::class)
@Composable
fun rememberResolvedTextStyle(style: Style, styleState: StyleState? = null): State<TextStyle> {
    val density = LocalDensity.current
    val theme = LocalAppTheme.current
    val locals = currentComposer.currentCompositionLocalMap
    val state = styleState ?: remember { MutableStyleState(null) }
    return remember(style, density, theme, state, locals) {
        derivedStateOf {
            TextStyleCollectingScope(density, locals, state)
                .also { scope -> with(style) { scope.applyStyle() } }
                .result
        }
    }
}

@OptIn(ExperimentalFoundationStyleApi::class)
private class TextStyleCollectingScope(
    density: Density,
    private val locals: CompositionLocalMap,
    override val state: StyleState,
) : StyleScope, Density by density {
    var result: TextStyle = TextStyle.Default
        private set

    override val <T> CompositionLocal<T>.currentValue: T
        get() = locals[this]

    // State / animation
    override fun <T> state(
        key: StyleStateKey<T>,
        block: () -> Unit,
        active: (key: StyleStateKey<T>, state: StyleState) -> Boolean,
    ) {
        if (active(key, state)) block()
    }

    override fun animate(
        toSpec: AnimationSpec<Float>,
        fromSpec: AnimationSpec<Float>,
        block: () -> Unit
    ) = block()

    // Text properties
    // Mirrors how Modifier.styleable decomposes textStyle(): only these properties are kept, so
    // e.g. lineHeightStyle and platformStyle are intentionally dropped to render identically.
    override fun textStyle(value: TextStyle) {
        val span = value.toSpanStyle()
        if (span.color.isSpecified) contentColor(span.color)
        if (span.fontSize.isSpecified) fontSize(span.fontSize)
        if (span.letterSpacing.isSpecified) letterSpacing(span.letterSpacing)
        span.brush?.let { contentBrush(it) }
        span.fontStyle?.let { fontStyle(it) }
        span.baselineShift?.let { if (it != BaselineShift.Unspecified) baselineShift(it) }
        span.fontWeight?.let { fontWeight(it) }
        span.textDecoration?.let { textDecoration(it) }
        span.fontSynthesis?.let { fontSynthesis(it) }
        span.fontFamily?.let { fontFamily(it) }

        val paragraph = value.toParagraphStyle()
        paragraph.textIndent?.let { textIndent(it) }
        if (paragraph.lineHeight.isSpecified) lineHeight(paragraph.lineHeight)
        if (paragraph.lineBreak != LineBreak.Unspecified) lineBreak(paragraph.lineBreak)
        if (paragraph.hyphens != Hyphens.Unspecified) hyphens(paragraph.hyphens)
        if (paragraph.textDirection != TextDirection.Unspecified) textDirection(paragraph.textDirection)
        if (paragraph.textAlign != TextAlign.Unspecified) textAlign(paragraph.textAlign)
        paragraph.textMotion?.let { textMotion(it) }
    }
    override fun contentColor(value: Color) { result = result.copy(color = value) }
    override fun contentBrush(value: Brush) { result = result.copy(brush = value) }
    override fun textDecoration(value: TextDecoration) { result = result.copy(textDecoration = value) }
    override fun fontFamily(value: FontFamily) { result = result.copy(fontFamily = value) }
    override fun textIndent(value: TextIndent) { result = result.copy(textIndent = value) }
    override fun fontSize(value: TextUnit) { result = result.copy(fontSize = value) }
    override fun lineHeight(value: TextUnit) { result = result.copy(lineHeight = value) }
    override fun letterSpacing(value: TextUnit) { result = result.copy(letterSpacing = value) }
    override fun baselineShift(value: BaselineShift) { result = result.copy(baselineShift = value) }
    override fun fontWeight(value: FontWeight) { result = result.copy(fontWeight = value) }
    override fun fontStyle(value: FontStyle) { result = result.copy(fontStyle = value) }
    override fun textDirection(value: TextDirection) { result = result.copy(textDirection = value) }
    override fun textAlign(value: TextAlign) { result = result.copy(textAlign = value) }
    override fun lineBreak(value: LineBreak) { result = result.copy(lineBreak = value) }
    override fun hyphens(value: Hyphens) { result = result.copy(hyphens = value) }
    override fun fontSynthesis(value: FontSynthesis) { result = result.copy(fontSynthesis = value) }
    override fun textMotion(value: TextMotion) { result = result.copy(textMotion = value) }

    // Layout, layer and draw properties are applied by Modifier.styleable; ignore them here.
    override fun contentPaddingStart(value: Dp) = Unit
    override fun contentPaddingEnd(value: Dp) = Unit
    override fun contentPaddingTop(value: Dp) = Unit
    override fun contentPaddingBottom(value: Dp) = Unit
    override fun externalPaddingStart(value: Dp) = Unit
    override fun externalPaddingEnd(value: Dp) = Unit
    override fun externalPaddingTop(value: Dp) = Unit
    override fun externalPaddingBottom(value: Dp) = Unit
    override fun borderWidth(value: Dp) = Unit
    override fun borderColor(value: Color) = Unit
    override fun borderBrush(value: Brush) = Unit
    override fun width(value: Dp) = Unit
    override fun height(value: Dp) = Unit
    override fun width(fraction: Float) = Unit
    override fun height(fraction: Float) = Unit
    override fun left(value: Dp) = Unit
    override fun top(value: Dp) = Unit
    override fun right(value: Dp) = Unit
    override fun bottom(value: Dp) = Unit
    override fun minWidth(value: Dp) = Unit
    override fun minHeight(value: Dp) = Unit
    override fun maxWidth(value: Dp) = Unit
    override fun maxHeight(value: Dp) = Unit
    override fun alpha(value: Float) = Unit
    override fun scaleX(value: Float) = Unit
    override fun scaleY(value: Float) = Unit
    override fun translationX(value: Float) = Unit
    override fun translationY(value: Float) = Unit
    override fun rotationX(value: Float) = Unit
    override fun rotationY(value: Float) = Unit
    override fun rotationZ(value: Float) = Unit
    override fun colorFilter(value: ColorFilter?) = Unit
    override fun transformOriginX(value: Float) = Unit
    override fun transformOriginY(value: Float) = Unit
    override fun clip(value: Boolean) = Unit
    override fun zIndex(value: Float) = Unit
    override fun background(color: Color) = Unit
    override fun background(value: Brush) = Unit
    override fun foreground(value: Color) = Unit
    override fun foreground(value: Brush) = Unit
    override fun shape(value: Shape) = Unit
    override fun dropShadow(value: Shadow) = Unit
    override fun dropShadow(vararg value: Shadow) = Unit
    override fun innerShadow(value: Shadow) = Unit
    override fun innerShadow(vararg value: Shadow) = Unit
}
