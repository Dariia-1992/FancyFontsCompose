package com.smartfoxlabs.fancy.stylish.font.keyboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.components.RallyTabRow
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme.FancyFontTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FancyFontApp()
        }
    }
}

@Preview
@Composable
fun FancyFontApp() {
    FancyFontTheme {
        val allScreens = RallyFontScreen.values().toList()
        var currentScreen by rememberSaveable { mutableStateOf(RallyFontScreen.Calligraphy) }
        Scaffold(
            bottomBar = {
                RallyTabRow(allScreens = allScreens,
                    onTabSelected = { screen -> currentScreen = screen },
                    currentScreen = currentScreen)
            }
        ) { innerPadding ->
            Box(Modifier.padding(innerPadding)) {
                currentScreen.content(
                    onScreenChange = { screen ->
                        currentScreen = RallyFontScreen.valueOf(screen)
                    }
                )
            }
        }
    }
}




