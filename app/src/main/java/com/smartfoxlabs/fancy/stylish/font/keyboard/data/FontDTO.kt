package com.smartfoxlabs.fancy.stylish.font.keyboard.data

import androidx.compose.runtime.Immutable
import com.smartfoxlabs.fancy.stylish.font.keyboard.R

@Immutable
data class FontDTO (
    var name: String? ="",
    var background: Int = R.drawable.yellow_background,
    var file: String? = "",
    var premium: Boolean = false,
    var type: String? = "",
    var symbols: ArrayList<String> = arrayListOf<String>()) {
}

object FontData{
    val fonts: List<FontDTO> = listOf(
        FontDTO("Maghrib", R.drawable.abstract_blue_geometric,
            "font/Maghrib.ttf", false, "caligraphic",
            arrayListOf("ru", "en")),
        FontDTO("Abelone", R.drawable.yellow_background,
            "font/Abelone.otf", false, "caligraphic",
            arrayListOf("ru", "en")),
        FontDTO(  "LovelyCoffee", R.drawable.photo,
            "font/LovelyCoffee.ttf", false, "caligraphic",
            arrayListOf("ru", "en")),
        FontDTO("Playbox", R.drawable.abstract_blue_geometric,
            "font/playbox.otf", false, "caligraphic",
            arrayListOf("ru", "en")),
        FontDTO(   "Sexy", R.drawable.yellow_background,
            "font/sexy.ttf", false, "caligraphic",
            arrayListOf("ru", "en"))
    )
}