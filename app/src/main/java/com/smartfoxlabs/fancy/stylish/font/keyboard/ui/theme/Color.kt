package com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.material.lightColors

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val White = Color(0xf1FFF1)
val Black = Color(0x00)
val SelectedColor = Color(0x0380F3)
val NavBarColor = Color(0xA0B1C1)
val VipCarBg = Color(0xAEC1D2)
val ItemCheckColor = Color(0x0A43FE)

val FontColorPalette = lightColors(
    primary = Black,
    background = White,
    primaryVariant = NavBarColor,
    onPrimary = SelectedColor,
    onSurface = White
)

val BottomNavigationColorPalette = lightColors(
    primary = White,
    onPrimary = NavBarColor
)