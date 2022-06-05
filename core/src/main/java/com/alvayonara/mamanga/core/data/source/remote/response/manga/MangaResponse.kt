package com.alvayonara.mamanga.core.data.source.remote.response.manga


import com.google.gson.annotations.SerializedName

data class MangaResponse(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("message")
    val message: String?,
    @SerializedName("result")
    val result: List<Result>? = null,
    @SerializedName("status")
    val status: String?
)