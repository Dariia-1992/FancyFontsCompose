package com.smartfoxlabs.fancy.stylish.font.keyboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.smartfoxlabs.fancy.stylish.font.keyboard.ui.theme.FancyFontTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FancyFontTheme {
                MainScreen()
            }
        }
    }
}





