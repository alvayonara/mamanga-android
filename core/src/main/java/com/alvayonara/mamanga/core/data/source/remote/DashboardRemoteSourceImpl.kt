package com.alvayonara.mamanga.core.data.source.remote

import com.alvayonara.mamanga.core.data.source.remote.network.MaMangaService
import com.alvayonara.mamanga.core.data.source.remote.response.manga.MangaResponse
import com.alvayonara.mamanga.core.domain.remote.DashboardRemoteSource
import io.reactivex.Observable

class DashboardRemoteSourceImpl constructor(private val maMangaService: MaMangaService) :
    DashboardRemoteSource {

    override fun getNewRelease(): Observable<MangaResponse> = maMangaService.newRelease()

    override fun getUpdateManga(): Observable<MangaResponse> = maMangaService.updateManga()

    override fun getMostPopular(): Observable<MangaResponse> = maMangaService.mostPopular()

    override fun getReleaseSoon(): Observable<MangaResponse> = maMangaService.releaseSoon()
}