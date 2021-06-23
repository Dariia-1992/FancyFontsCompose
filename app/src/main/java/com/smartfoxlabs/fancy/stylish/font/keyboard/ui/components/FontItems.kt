package com.smartfoxlabs.fancy.stylish.font.keyboard.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.smartfoxlabs.fancy.stylish.font.keyboard.data.FontDTO
import com.smartfoxlabs.fancy.stylish.font.keyboard.data.FontData

@Composable
fun FontItems(fontsList: MutableList<List<FontDTO>>) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(144.dp)
        .padding(16.dp)
        .background(Color.DarkGray)){

        Text(text = "Test",
            modifier = Modifier.align(Alignment.CenterVertically)
                .fillMaxSize())

    }
}
