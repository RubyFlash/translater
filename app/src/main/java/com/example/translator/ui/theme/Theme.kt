package com.example.translator.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = dark_theme_primary,
    onPrimary = dark_theme_onPrimary,
    primaryContainer = dark_theme_primaryContainer,
    onPrimaryContainer = dark_theme_onPrimaryContainer,
    secondary = dark_theme_secondary,
    onSecondary = dark_theme_onSecondary,
    secondaryContainer = dark_theme_secondaryContainer,
    onSecondaryContainer = dark_theme_onSecondaryContainer,
    tertiary = dark_theme_tertiary,
    onTertiary = dark_theme_onTertiary,
    tertiaryContainer = dark_theme_tertiaryContainer,
    onTertiaryContainer = dark_theme_onTertiaryContainer,
    error = dark_theme_error,
    onError = dark_theme_onError,
    errorContainer = dark_theme_errorContainer,
    onErrorContainer = dark_theme_onErrorContainer,
    background = dark_theme_background,
    onBackground = dark_theme_onBackground,
    surface = dark_theme_surface,
    onSurface = dark_theme_onSurface
)

private val LightColorScheme = lightColorScheme(
    primary = light_theme_primary,
    onPrimary = light_theme_onPrimary,
    primaryContainer = light_theme_primaryContainer,
    onPrimaryContainer = light_theme_onPrimaryContainer,
    secondary = light_theme_secondary,
    onSecondary = light_theme_onSecondary,
    secondaryContainer = light_theme_secondaryContainer,
    onSecondaryContainer = light_theme_onSecondaryContainer,
    tertiary = light_theme_tertiary,
    onTertiary = light_theme_onTertiary,
    tertiaryContainer = light_theme_tertiaryContainer,
    onTertiaryContainer = light_theme_onTertiaryContainer,
    error = light_theme_error,
    onError = light_theme_onError,
    errorContainer = light_theme_errorContainer,
    onErrorContainer = light_theme_onErrorContainer,
    background = light_theme_background,
    onBackground = light_theme_onBackground,
    surface = light_theme_surface,
    onSurface = light_theme_onSurface
)

@Composable
fun TranslatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}