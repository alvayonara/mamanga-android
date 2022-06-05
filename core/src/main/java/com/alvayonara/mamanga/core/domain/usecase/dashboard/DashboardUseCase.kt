package com.alvayonara.mamanga.core.domain.usecase.dashboard

import com.alvayonara.mamanga.common.model.manga.Manga
import io.reactivex.Observable

interface DashboardUseCase {

    fun getNewRelease(): Observable<Manga>
    fun getUpdateManga(): Observable<Manga>
    fun getMostPopular(): Observable<Manga>
    fun getReleaseSoon(): Observable<Manga>
}