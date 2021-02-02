package com.strangecoder.region.models

data class CountryItem(
    val name: String,
    val capital: String,
    val flag: String,
    val region: String,
    val subregion: String,
    val population: Int,
    val borders: List<String>,
    val languages: List<Language>
)