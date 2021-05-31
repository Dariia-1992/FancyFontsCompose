package com.smartfoxlabs.fancy.stylish.font.keyboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.overview.OverviewBody

enum class RallyFontScreen(
    val icon: Int,
    val title: Int,
    val body: @Composable ((String) -> Unit) -> Unit
) {
    Calligraphy(
        icon = R.drawable.icon_calligraphy,
        title = R.string.nav_bar_item_fonts_calligraphic,
        body = { OverviewBody()}),
    Colored(
        icon = R.drawable.icon_colored,
        title = R.string.nav_bar_item_fonts_colored,
        body = { OverviewBody()}
    ),
    Favorites(
        icon = R.drawable.icon_favorites,
        title = R.string.nav_bar_item_fonts_favorites,
        body = { OverviewBody()}
    ),
    Settings(
       icon = R.drawable.icon_settings,
       title = R.string.nav_bar_item_settings,
       body = { OverviewBody()}
    );

    @Composable
    fun content(onScreenChange: (String) -> Unit) {
        body(onScreenChange)
    }
}