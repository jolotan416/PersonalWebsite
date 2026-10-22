package com.example.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import personalwebsite.shared.generated.resources.Res
import personalwebsite.shared.generated.resources.alata_regular
import personalwebsite.shared.generated.resources.montserrat_black
import personalwebsite.shared.generated.resources.montserrat_blackitalic
import personalwebsite.shared.generated.resources.montserrat_bold
import personalwebsite.shared.generated.resources.montserrat_bolditalic
import personalwebsite.shared.generated.resources.montserrat_extrabold
import personalwebsite.shared.generated.resources.montserrat_extrabolditalic
import personalwebsite.shared.generated.resources.montserrat_extralight
import personalwebsite.shared.generated.resources.montserrat_extralightitalic
import personalwebsite.shared.generated.resources.montserrat_italic
import personalwebsite.shared.generated.resources.montserrat_light
import personalwebsite.shared.generated.resources.montserrat_lightitalic
import personalwebsite.shared.generated.resources.montserrat_medium
import personalwebsite.shared.generated.resources.montserrat_mediumitalic
import personalwebsite.shared.generated.resources.montserrat_regular
import personalwebsite.shared.generated.resources.montserrat_semibold
import personalwebsite.shared.generated.resources.montserrat_semibolditalic
import personalwebsite.shared.generated.resources.montserrat_thin
import personalwebsite.shared.generated.resources.montserrat_thinitalic

@Composable
fun displayFontFamily() = FontFamily(
    Font(Res.font.montserrat_black, weight = FontWeight.Black),
    Font(Res.font.montserrat_blackitalic, weight = FontWeight.Black, style = FontStyle.Italic),
    Font(Res.font.montserrat_bold, weight = FontWeight.Bold),
    Font(Res.font.montserrat_bolditalic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(Res.font.montserrat_extrabold, weight = FontWeight.ExtraBold),
    Font(
        Res.font.montserrat_extrabolditalic,
        weight = FontWeight.ExtraBold,
        style = FontStyle.Italic
    ),
    Font(Res.font.montserrat_extralight, weight = FontWeight.ExtraLight),
    Font(
        Res.font.montserrat_extralightitalic,
        weight = FontWeight.ExtraLight,
        style = FontStyle.Italic
    ),
    Font(Res.font.montserrat_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(Res.font.montserrat_light, weight = FontWeight.Light),
    Font(Res.font.montserrat_lightitalic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(Res.font.montserrat_medium, weight = FontWeight.Medium),
    Font(Res.font.montserrat_mediumitalic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(Res.font.montserrat_regular, weight = FontWeight.Normal),
    Font(Res.font.montserrat_semibold, weight = FontWeight.SemiBold),
    Font(
        Res.font.montserrat_semibolditalic,
        weight = FontWeight.SemiBold,
        style = FontStyle.Italic
    ),
    Font(Res.font.montserrat_thin, weight = FontWeight.Thin),
    Font(Res.font.montserrat_thinitalic, weight = FontWeight.Thin, style = FontStyle.Italic),
)

@Composable
fun bodyFontFamily() = FontFamily(
    Font(Res.font.alata_regular, FontWeight.Normal)
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

