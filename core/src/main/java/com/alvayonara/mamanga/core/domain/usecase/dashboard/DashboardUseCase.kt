package com.alvayonara.mamanga.core.domain.usecase.dashboard

import com.alvayonara.mamanga.common.model.manga.Result
import io.reactivex.Observable

interface DashboardUseCase {

    fun getNewRelease(): Observable<List<Result>>
    fun getUpdateManga(): Observable<List<Result>>
    fun getMostPopular(): Observable<List<Result>>
    fun getReleaseSoon(): Observable<List<Result>>
}