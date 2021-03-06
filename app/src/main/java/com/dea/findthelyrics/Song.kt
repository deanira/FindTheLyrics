package com.dea.findthelyrics

data class Song(
    var title: String = "",
    var singer: String = "",
    var releasedYear: String = "",
    var lyrics: String = "",
    var cover: Int = 0
)