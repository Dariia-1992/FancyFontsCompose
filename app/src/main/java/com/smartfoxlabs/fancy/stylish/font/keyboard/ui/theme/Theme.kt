package com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = SelectedColor,
    primaryVariant = Purple700,
    secondary = Teal200,

    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

@Composable
fun FancyFontsComposeTheme( darkTheme: Boolean = isSystemInDarkTheme(),
                            content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        FontColorPalette
    } else {
        FontColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}

@Composable
fun BottomNavigationTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = BottomNavigationColorPalette,
        typography = Typography,
        content = content
    )
}