package com.smartfoxlabs.fancy.stylish.font.keyboard.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//@Composable
//fun RallyTabRow(
//    allScreens: List<MainFontScreen>,
//    onTabSelected: (MainFontScreen) -> Unit,
//    currentScreen: MainFontScreen
//) {
//    Surface(
//        Modifier
//            .height(TabHeight)
//            .fillMaxWidth()
//    ) {
//        Row(horizontalArrangement = Arrangement.SpaceAround) {
//            allScreens.forEach { screen ->
//                RallyTab(
//                    text = screen.title,
//                    icon = screen.icon,
//                    onSelected = { onTabSelected(screen) },
//                    selected = currentScreen == screen)
//            }
//        }
//    }
//}

@Composable
private fun RallyTab(
    text: Int,
    icon: Int,
    onSelected: () -> Unit,
    selected: Boolean) {

    val selectedColor = Color(0x0380F3)
    val color = Color(0xA0B1C1)
    val tabTintColor by animateColorAsState(targetValue = if (selected) selectedColor else color)

    Column( verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier
        .height(TabHeight)
        .selectable(
            selected = selected,
            onClick = onSelected,
            role = Role.Tab
        )) {
        Box(modifier = Modifier
            .weight(2f)) {
            //Icon(painter = painterResource(id = icon), contentDescription = null, tint = tabTintColor)
            Image(bitmap = ImageBitmap.imageResource(id = icon),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier.align(Alignment.Center))
            //Icon(bitmap = ImageBitmap.imageResource(id = icon), contentDescription = null, tint = tabTintColor)
            Text(
                text = "text",
                fontSize = 12.sp,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            )
            if (selected) {

            }
        }
    }
}

private val TabHeight = 56.dp