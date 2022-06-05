package com.alvayonara.mamanga.core.domain.remote

import com.alvayonara.mamanga.core.data.source.remote.response.manga.MangaResponse
import io.reactivex.Observable

interface DashboardRemoteSource {

    fun getNewRelease(): Observable<MangaResponse>
    fun getUpdateManga(): Observable<MangaResponse>
    fun getMostPopular(): Observable<MangaResponse>
    fun getReleaseSoon(): Observable<MangaResponse>
}