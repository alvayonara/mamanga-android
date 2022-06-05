package com.alvayonara.mamanga.common.model.manga

data class Result(
    val genres: List<Genre>? = null,
    val id: String,
    val image: String,
    val name: String,
    val synopsis: String,
    val updatedChapter: String
)