package com.smartfoxlabs.fancy.stylish.font.keyboard.ui.components

import androidx.annotation.StringRes
import com.smartfoxlabs.fancy.stylish.font.keyboard.R

sealed class BottomNavigationItemsScreens(val route: String, @StringRes val resourceId: Int, val icon: Int) {
    object Calligraphy: BottomNavigationItemsScreens("Calligraphy", R.string.nav_bar_item_fonts_calligraphic, R.drawable.icon_calligraphy)
    object Colored: BottomNavigationItemsScreens("Colored", R.string.nav_bar_item_fonts_colored, R.drawable.icon_colored)
    object Favorites: BottomNavigationItemsScreens("Favorites", R.string.nav_bar_item_fonts_favorites, R.drawable.icon_favorites)
    object Settings: BottomNavigationItemsScreens("Settings", R.string.nav_bar_item_settings, R.drawable.icon_settings)
}