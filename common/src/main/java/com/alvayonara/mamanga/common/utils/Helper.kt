package com.alvayonara.mamanga.common.utils

import android.content.Context
import com.alvayonara.mamanga.common.R
import com.alvayonara.mamanga.common.model.header.Header
import com.alvayonara.mamanga.common.model.manga.Genre

object Helper {

    fun Context.getDashboardHeader(header: Header): Pair<String, String> {
        var title = ""
        var subtitle = ""
        when (header) {
            Header.NEW_RELEASE -> {
                title = this.getString(R.string.title_new_release)
                subtitle = this.getString(R.string.subtitle_new_release)
            }
            Header.CONTINUE_READ -> title = this.getString(R.string.title_continue_read)
            Header.UPDATE -> {
                title = this.getString(R.string.title_update)
                subtitle = this.getString(R.string.subtitle_update)
            }
            Header.POPULAR -> {
                title = this.getString(R.string.title_popular)
                subtitle = this.getString(R.string.subtitle_popular)
            }
            Header.RELEASE_SOON -> {
                title = this.getString(R.string.title_release_soon)
                subtitle = this.getString(R.string.subtitle_release_soon)
            }
        }
        return Pair(title, subtitle)
    }

    fun removeLastChar(sentence: String): String = sentence.substring(0, sentence.length - 1)

    fun generateMangaGenre(list: List<Genre>): String {
        var genre = ""
        list.forEach {
            genre += "${it.name},"
        }
        return removeLastChar(genre)
    }
}