package com.smartfoxlabs.fancy.stylish.font.keyboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme.FancyFontsComposeTheme
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme.FontColorPalette


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FancyFontsComposeTheme() {

                Surface () {
                    MainScreen()
                }
            }
        }
    }
}





