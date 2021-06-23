package com.smartfoxlabs.fancy.stylish.font.keyboard.ui.font

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun FancyFontApp() {
        Scaffold {
            FancyFontCard()
        }
}

@Composable
fun FancyFontCard(names: List<String> = listOf("Android", "there", "hfhffhhf", "Alfred Sisley")) {
    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .padding(start = 16.dp)
            .background(Color.Green)
            .fillMaxHeight(1f)
    ) {
        items(50){
            FontItem(index = it)
        }
    }
}

@Composable
fun FontItem(index: Int) {
    Card(modifier = Modifier
        .padding(0.dp, 6.dp)
        .size(360.dp, 50.dp)) {

        Spacer(Modifier.width(200.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}