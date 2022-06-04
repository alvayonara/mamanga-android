package com.alvayonara.mamanga.core.data.domain.model.manga

data class Manga(
    val code: Int,
    val message: String,
    val result: List<Result>,
    val status: String
)