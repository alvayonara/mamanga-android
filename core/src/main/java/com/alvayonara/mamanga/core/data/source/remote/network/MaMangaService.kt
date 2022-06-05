package com.alvayonara.mamanga.core.data.source.remote.network

import com.alvayonara.mamanga.core.data.source.remote.response.manga.MangaResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface MaMangaService {

    @GET("newRelease")
    fun newRelease(): Observable<MangaResponse>

    @GET("updateManga")
    fun updateManga(): Observable<MangaResponse>

    @GET("mostPopular")
    fun mostPopular(): Observable<MangaResponse>

    @GET("releaseSoon")
    fun releaseSoon(): Observable<MangaResponse>
}