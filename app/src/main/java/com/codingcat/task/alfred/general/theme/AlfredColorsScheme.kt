package com.codingcat.task.alfred.general.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class AlfredColors(
    val colorPrimary: Color,
    val colorPrimaryDark: Color,
    val colorAccent: Color,
    val greenGray: Color,
    val lightGreenGray: Color,
    val gray: Color,
    val whiteGray: Color,
    val white: Color,
    val red: Color,
    val black: Color
)

val LocalAlfredColors = staticCompositionLocalOf {
    AlfredColors(
        colorPrimary = Color.Unspecified,
        colorPrimaryDark = Color.Unspecified,
        colorAccent = Color.Unspecified,
        greenGray = Color.Unspecified,
        lightGreenGray = Color.Unspecified,
        gray = Color.Unspecified,
        whiteGray = Color.Unspecified,
        white = Color.Unspecified,
        red = Color.Unspecified,
        black = Color.Unspecified
    )
}

fun AlfredColors.toColorScheme(): ColorScheme =
    ColorScheme(
        primary = this.colorPrimary,
        onPrimary = this.whiteGray,
        primaryContainer = this.whiteGray,
        onPrimaryContainer = this.whiteGray,
        inversePrimary = this.whiteGray,
        secondary = this.greenGray,
        onSecondary = this.white,
        secondaryContainer = this.lightGreenGray,
        onSecondaryContainer = this.white,
        tertiary = this.gray,
        onTertiary = this.gray,
        tertiaryContainer = this.gray,
        onTertiaryContainer = this.gray,
        background = this.whiteGray,
        onBackground = this.lightGreenGray,
        surface = this.white,
        onSurface = this.greenGray,
        surfaceVariant = this.greenGray,
        onSurfaceVariant = this.greenGray,
        surfaceTint = this.greenGray,
        inverseSurface = this.greenGray,
        inverseOnSurface = this.greenGray,
        error = this.red,
        onError = this.white,
        errorContainer = this.red,
        onErrorContainer = this.red,
        outline = this.gray,
        outlineVariant = this.gray,
        scrim = this.gray,
        surfaceBright = this.white,
        surfaceDim = this.whiteGray,
        surfaceContainer = this.white,
        surfaceContainerHigh = this.white,
        surfaceContainerHighest = this.white,
        surfaceContainerLow = this.gray,
        surfaceContainerLowest = this.gray,
    )