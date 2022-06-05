package com.alvayonara.mamanga.core.data.source.remote.response.manga


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("genres")
    val genres: List<Genre>? = null,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("synopsis")
    val synopsis: String?,
    @SerializedName("updated_chapter")
    val updatedChapter: String?
)