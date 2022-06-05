package com.alvayonara.mamanga.core.domain.usecase.dashboard

import com.alvayonara.mamanga.common.model.manga.Manga
import com.alvayonara.mamanga.common.model.manga.Result
import com.alvayonara.mamanga.core.domain.repository.DashboardRepository
import io.reactivex.Observable

class DashboardInteractor constructor(private val dashboardRepository: DashboardRepository) :
    DashboardUseCase {

    override fun getNewRelease(): Observable<List<Result>> =
        dashboardRepository.getNewRelease().map { it.result }

    override fun getUpdateManga(): Observable<List<Result>> =
        dashboardRepository.getUpdateManga().map { it.result }

    override fun getMostPopular(): Observable<List<Result>> =
        dashboardRepository.getMostPopular().map { it.result }

    override fun getReleaseSoon(): Observable<List<Result>> =
        dashboardRepository.getReleaseSoon().map { it.result }
}