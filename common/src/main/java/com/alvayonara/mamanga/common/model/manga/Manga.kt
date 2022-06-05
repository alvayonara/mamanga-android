package com.alvayonara.mamanga.common.model.manga

data class Manga(
    val code: Int,
    val message: String,
    val result: List<Result>? = null,
    val status: String
)