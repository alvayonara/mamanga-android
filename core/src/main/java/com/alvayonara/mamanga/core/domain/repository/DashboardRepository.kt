package com.alvayonara.mamanga.core.domain.repository

import com.alvayonara.mamanga.common.model.manga.Manga
import io.reactivex.Observable

interface DashboardRepository {

    fun getNewRelease(): Observable<Manga>
    fun getUpdateManga(): Observable<Manga>
    fun getMostPopular(): Observable<Manga>
    fun getReleaseSoon(): Observable<Manga>
}