package com.codingcat.task.alfred.general.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColors = AlfredColors(
    colorPrimary = GreenGrayLight,
    colorPrimaryDark = BlackLight,
    colorAccent = WhiteLight,
    greenGray = GreenGrayLight,
    lightGreenGray = LightGreenGrayLight,
    gray = GrayLight,
    whiteGray = WhiteGrayLight,
    white = WhiteLight,
    white20p = White20pLight,
    red = RedLight,
    black = BlackLight
)

private val DarkColors = AlfredColors(
    colorPrimary = GreenGrayDark,
    colorPrimaryDark = BlackDark,
    colorAccent = WhiteDark,
    greenGray = GreenGrayDark,
    lightGreenGray = LightGreenGrayDark,
    gray = GrayDark,
    whiteGray = WhiteGrayDark,
    white = WhiteDark,
    white20p = White20pDark,
    red = RedDark,
    black = BlackDark
)

@Composable
fun AlfredTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColors.toColorScheme()
        else -> LightColors.toColorScheme()
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    CompositionLocalProvider(
        LocalAlfredColors provides if (darkTheme) DarkColors else LightColors,
        LocalAlfredTypography provides Typography
    ) {
        MaterialTheme(
            shapes = shapes,
            colorScheme = colorScheme,
            content = content
        )
    }
}

object AlfredTheme {
    val typography: AlfredTypography
        @Composable
        get() = LocalAlfredTypography.current

    val colors: AlfredColors
        @Composable
        get() = LocalAlfredColors.current
}