package com.smartfoxlabs.fancy.stylish.font.keyboard.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.smartfoxlabs.fancy.stylish.font.keyboard.RallyFontScreen

@Composable
fun RallyTabRow(
    allScreens: List<RallyFontScreen>,
    onTabSelected: (RallyFontScreen) -> Unit,
    currentScreen: RallyFontScreen
) {
    Surface(
        Modifier
            .height(TabHeight)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(Modifier.selectableGroup()) {
            allScreens.forEach { screen ->
                RallyTab(
                    text = screen.title,
                    icon = screen.icon,
                    onSelected = { onTabSelected(screen) },
                    selected = currentScreen == screen)
            }
        }
    }
}

@Composable
private fun RallyTab(
    text: Int,
    icon: Int,
    onSelected: () -> Unit,
    selected: Boolean) {

    val selectedColor = Color(0x0380F3)
    val color = Color(0xA0B1C1)
    val tabTintColor by animateColorAsState(targetValue = if (selected) selectedColor else color)

    Row( modifier = Modifier
        .height(TabHeight)
        .selectable(
            selected = selected,
            onClick = onSelected,
            role = Role.Tab
        )) {
        Icon(painter = painterResource(id = icon), contentDescription = null, tint = tabTintColor)
        if (selected) {

        }
    }
}

private val TabHeight = 56.dp