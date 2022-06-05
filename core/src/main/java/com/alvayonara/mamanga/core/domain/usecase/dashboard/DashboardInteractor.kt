package com.alvayonara.mamanga.core.domain.usecase.dashboard

import com.alvayonara.mamanga.common.model.manga.Manga
import com.alvayonara.mamanga.core.domain.repository.DashboardRepository
import io.reactivex.Observable

class DashboardInteractor constructor(private val dashboardRepository: DashboardRepository) :
    DashboardUseCase {

    override fun getNewRelease(): Observable<Manga> = dashboardRepository.getNewRelease()

    override fun getUpdateManga(): Observable<Manga> = dashboardRepository.getUpdateManga()

    override fun getMostPopular(): Observable<Manga> = dashboardRepository.getMostPopular()

    override fun getReleaseSoon(): Observable<Manga> = dashboardRepository.getReleaseSoon()
}