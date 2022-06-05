package com.alvayonara.mamanga.core.domain.mapper.dashboardmapper

import com.alvayonara.mamanga.common.model.manga.Genre
import com.alvayonara.mamanga.common.model.manga.Manga
import com.alvayonara.mamanga.common.model.manga.Result
import com.alvayonara.mamanga.core.data.source.remote.response.manga.MangaResponse

object DashboardMapper {

    fun MangaResponse.mapMangaResponsesToDomain() =
        Manga(
            code = code ?: 0,
            message = message ?: "",
            result = result?.map { results ->
                Result(
                    genres = results.genres?.map { genres ->
                        Genre(
                            id = genres.id ?: 0,
                            name = genres.name ?: "-"
                        )
                    },
                    id = results.id ?: "",
                    image = results.image ?: "",
                    name = results.name ?: "-",
                    synopsis = results.synopsis ?: "-",
                    updatedChapter = results.updatedChapter ?: "-"
                )
            },
            status = status ?: ""
        )
}