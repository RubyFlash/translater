package com.example.translater.ui.theme

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
    primary = Blue80,
    onPrimary = Blue20,
    primaryContainer = Blue30,
    onPrimaryContainer = Blue90,
    secondary = Grey80,
    onSecondary = Grey20,
    secondaryContainer = Grey30,
    onSecondaryContainer = Grey90,
    tertiary = Pink80,
    onTertiary = Pink20,
    tertiaryContainer = Pink30,
    onTertiaryContainer = Pink90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Background10,
    onBackground = OnBackground90,
    surface = Surface10,
    onSurface = OnSurface90
)

private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = Blue100,
    primaryContainer = Blue90,
    onPrimaryContainer = Blue10,
    secondary = Grey40,
    onSecondary = Grey100,
    secondaryContainer = Grey90,
    onSecondaryContainer = Grey10,
    tertiary = Pink40,
    onTertiary = Pink100,
    tertiaryContainer = Pink90,
    onTertiaryContainer = Pink10,
    error = Red40,
    onError = Red100,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = Background99,
    onBackground = OnBackground10,
    surface = Surface99,
    onSurface = OnSurface10
)

@Composable
fun TranslaterTheme(
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