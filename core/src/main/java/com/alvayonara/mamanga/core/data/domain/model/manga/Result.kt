package com.alvayonara.mamanga.core.data.domain.model.manga

data class Result(
    val genres: List<Genre>,
    val id: String,
    val image: String,
    val name: String,
    val synopsis: String,
    val updated_chapter: String
)