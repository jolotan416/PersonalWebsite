package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import personalwebsite.shared.generated.resources.Res
import personalwebsite.shared.generated.resources.calsans_regular
import personalwebsite.shared.generated.resources.dmsans_black
import personalwebsite.shared.generated.resources.dmsans_blackitalic
import personalwebsite.shared.generated.resources.dmsans_bold
import personalwebsite.shared.generated.resources.dmsans_bolditalic
import personalwebsite.shared.generated.resources.dmsans_extrabold
import personalwebsite.shared.generated.resources.dmsans_extrabolditalic
import personalwebsite.shared.generated.resources.dmsans_extralight
import personalwebsite.shared.generated.resources.dmsans_extralightitalic
import personalwebsite.shared.generated.resources.dmsans_italic
import personalwebsite.shared.generated.resources.dmsans_light
import personalwebsite.shared.generated.resources.dmsans_lightitalic
import personalwebsite.shared.generated.resources.dmsans_medium
import personalwebsite.shared.generated.resources.dmsans_mediumitalic
import personalwebsite.shared.generated.resources.dmsans_regular
import personalwebsite.shared.generated.resources.dmsans_semibold
import personalwebsite.shared.generated.resources.dmsans_semibolditalic
import personalwebsite.shared.generated.resources.dmsans_thin
import personalwebsite.shared.generated.resources.dmsans_thinitalic


@Composable
fun displayFontFamily() = FontFamily(
    Font(Res.font.calsans_regular, FontWeight.Normal)
)

@Composable
fun bodyFontFamily() = FontFamily(
    Font(Res.font.dmsans_black, weight = FontWeight.Black),
    Font(Res.font.dmsans_blackitalic, weight = FontWeight.Black, style = FontStyle.Italic),
    Font(Res.font.dmsans_bold, weight = FontWeight.Bold),
    Font(Res.font.dmsans_bolditalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.dmsans_extrabold, weight = FontWeight.ExtraBold),
    Font(
        Res.font.dmsans_extrabolditalic,
        weight = FontWeight.ExtraBold,
        style = FontStyle.Italic
    ),
    Font(Res.font.dmsans_extralight, weight = FontWeight.ExtraLight),
    Font(
        Res.font.dmsans_extralightitalic,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Italic
    ),
    Font(Res.font.dmsans_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.dmsans_light, weight = FontWeight.Light),
    Font(Res.font.dmsans_lightitalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.dmsans_medium, weight = FontWeight.Medium),
    Font(Res.font.dmsans_mediumitalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.dmsans_regular, weight = FontWeight.Normal),
    Font(Res.font.dmsans_semibold, weight = FontWeight.SemiBold),
    Font(
        Res.font.dmsans_semibolditalic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    ),
    Font(Res.font.dmsans_thin, weight = FontWeight.Thin),
    Font(Res.font.dmsans_thinitalic, weight = FontWeight.Thin, style = FontStyle.Italic),
)

// Default Material 3 typography values
val baseline = Typography()


@Composable
fun AppTypography(): Typography {
    val displayFontFamily = displayFontFamily()
    val bodyFontFamily = bodyFontFamily()

    return Typography(
        displayLarge = baseline.displayLarge.copy(fontFamily = displayFontFamily),
        displayMedium = baseline.displayMedium.copy(fontFamily = displayFontFamily),
        displaySmall = baseline.displaySmall.copy(fontFamily = displayFontFamily),
        headlineLarge = baseline.headlineLarge.copy(fontFamily = displayFontFamily),
        headlineMedium = baseline.headlineMedium.copy(fontFamily = displayFontFamily),
        headlineSmall = baseline.headlineSmall.copy(fontFamily = displayFontFamily),
        titleLarge = baseline.titleLarge.copy(fontFamily = displayFontFamily),
        titleMedium = baseline.titleMedium.copy(fontFamily = displayFontFamily),
        titleSmall = baseline.titleSmall.copy(fontFamily = displayFontFamily),
        bodyLarge = baseline.bodyLarge.copy(fontFamily = bodyFontFamily),
        bodyMedium = baseline.bodyMedium.copy(fontFamily = bodyFontFamily),
        bodySmall = baseline.bodySmall.copy(fontFamily = bodyFontFamily),
        labelLarge = baseline.labelLarge.copy(fontFamily = bodyFontFamily),
        labelMedium = baseline.labelMedium.copy(fontFamily = bodyFontFamily),
        labelSmall = baseline.labelSmall.copy(fontFamily = bodyFontFamily),
    )
}

