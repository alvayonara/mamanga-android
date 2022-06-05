package com.alvayonara.mamanga.core.data.source

import com.alvayonara.mamanga.common.model.manga.Manga
import com.alvayonara.mamanga.core.domain.mapper.dashboardmapper.DashboardMapper.mapMangaResponsesToDomain
import com.alvayonara.mamanga.core.domain.remote.DashboardRemoteSource
import com.alvayonara.mamanga.core.domain.repository.DashboardRepository
import io.reactivex.Observable

class DashboardRepositoryImpl constructor(private val dashboardRemoteSource: DashboardRemoteSource) :
    DashboardRepository {

    override fun getNewRelease(): Observable<Manga> = dashboardRemoteSource.getNewRelease().map {
        it.mapMangaResponsesToDomain()
    }

    override fun getUpdateManga(): Observable<Manga> = dashboardRemoteSource.getUpdateManga().map {
        it.mapMangaResponsesToDomain()
    }

    override fun getMostPopular(): Observable<Manga> = dashboardRemoteSource.getMostPopular().map {
        it.mapMangaResponsesToDomain()
    }

    override fun getReleaseSoon(): Observable<Manga> = dashboardRemoteSource.getReleaseSoon().map {
        it.mapMangaResponsesToDomain()
    }
}