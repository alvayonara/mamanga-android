package com.alvayonara.mamanga.core.ui.dashboard

import android.content.Context
import android.view.Gravity
import androidx.recyclerview.widget.SnapHelper
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.alvayonara.mamanga.common.extension.gone
import com.alvayonara.mamanga.common.extension.gridLayout
import com.alvayonara.mamanga.common.extension.linearLayout
import com.alvayonara.mamanga.common.extension.visible
import com.alvayonara.mamanga.common.utils.ViewBindingKotlinModel
import com.alvayonara.mamanga.core.R
import com.alvayonara.mamanga.common.model.header.Header
import com.alvayonara.mamanga.common.utils.Helper
import com.alvayonara.mamanga.common.utils.Helper.getDashboardHeader
import com.alvayonara.mamanga.common.model.manga.Result
import com.alvayonara.mamanga.common.model.top.Top
import com.alvayonara.mamanga.core.databinding.*
import com.bumptech.glide.Glide
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper

class DashboardController(private val context: Context) : EpoxyController() {

    private var _top: Top? = null
    private val _newRelease: MutableList<Result> = mutableListOf()
    private val _continueRead: MutableList<Result> = mutableListOf()
    private val _update: MutableList<Result> = mutableListOf()
    private val _mostPopular: MutableList<Result> = mutableListOf()
    private val _releaseSoon: MutableList<Result> = mutableListOf()

    fun setTop(data: Top) {
        this._top = data
        requestModelBuild()
    }

    fun setNewRelease(data: MutableList<Result>) {
        this._newRelease.clear()
        this._newRelease.addAll(data)
        requestModelBuild()
    }

    fun setContinueRead(data: MutableList<Result>) {
        this._continueRead.clear()
        this._continueRead.addAll(data)
        requestModelBuild()
    }

    fun setUpdate(data: MutableList<Result>) {
        this._update.clear()
        this._update.addAll(data)
        requestModelBuild()
    }

    fun setMostPopular(data: MutableList<Result>) {
        this._mostPopular.clear()
        this._mostPopular.addAll(data)
        requestModelBuild()
    }

    fun setReleaseSoon(data: MutableList<Result>) {
        this._releaseSoon.clear()
        this._releaseSoon.addAll(data)
        requestModelBuild()
    }

    override fun buildModels() {
        Carousel.setDefaultGlobalSnapHelperFactory(object : Carousel.SnapHelperFactory() {
            override fun buildSnapHelper(context: Context?): SnapHelper =
                GravitySnapHelper(Gravity.CENTER)
        })

        this._top?.let {
            TopModel(context, it)
                .id(context.getString(R.string.top))
                .addTo(this)
        }

        HeaderModel(context, Header.NEW_RELEASE)
            .id(context.getString(R.string.header_new_release))
            .addIf(this._newRelease.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(26, 0, 26, 26, 16))
            .id(context.getString(R.string.new_release_carousel))
            .models(
                this._newRelease.mapIndexed { index, manga ->
                    NewReleaseModel(context, manga)
                        .id(context.getString(R.string.new_release, index))
                }
            )
            .onBind { _, view, _ ->
                view.linearLayout()
            }
            .addIf(this._newRelease.isNotEmpty(), this)

        HeaderModel(context, Header.CONTINUE_READ)
            .id(context.getString(R.string.header_continue_read))
            .addIf(this._continueRead.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(26, 0, 26, 26, 16))
            .id(context.getString(R.string.continue_read_carousel))
            .models(
                this._continueRead.mapIndexed { index, manga ->
                    ContinueReadModel(context, manga)
                        .id(context.getString(R.string.continue_read, index))
                }
            )
            .onBind { _, view, _ ->
                view.linearLayout()
            }
            .addIf(this._continueRead.isNotEmpty(), this)

        HeaderModel(context, Header.UPDATE)
            .id(context.getString(R.string.header_update))
            .addIf(this._update.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(26, 0, 26, 26, 16))
            .id(context.getString(R.string.update_carousel))
            .models(
                this._update.mapIndexed { index, manga ->
                    UpdateModel(context, manga)
                        .id(context.getString(R.string.update, index))
                }
            )
            .onBind { _, view, _ ->
                view.linearLayout()
            }
            .addIf(this._update.isNotEmpty(), this)

        HeaderModel(context, Header.POPULAR)
            .id(context.getString(R.string.header_popular))
            .addIf(this._mostPopular.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(20, 0, 20, 26, 12))
            .id(context.getString(R.string.popular_carousel))
            .models(
                this._mostPopular.mapIndexed { index, manga ->
                    PopularModel(context, manga)
                        .id(context.getString(R.string.popular, index))
                }
            )
            .onBind { _, view, _ ->
                view.gridLayout()
            }
            .addIf(this._mostPopular.isNotEmpty(), this)

        HeaderModel(context, Header.RELEASE_SOON)
            .id(context.getString(R.string.header_release_soon))
            .addIf(this._releaseSoon.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(26, 0, 26, 26, 16))
            .id(context.getString(R.string.release_soon_carousel))
            .models(
                this._releaseSoon.mapIndexed { index, manga ->
                    ReleaseSoonModel(context, manga)
                        .id(context.getString(R.string.release_soon, index))
                }
            )
            .onBind { _, view, _ ->
                view.linearLayout()
            }
            .addIf(this._releaseSoon.isNotEmpty(), this)
    }
}

data class HeaderModel(
    val context: Context,
    val header: Header
) : ViewBindingKotlinModel<ItemListHeaderBinding>(R.layout.item_list_header) {

    override fun ItemListHeaderBinding.bind() {
        tvHeaderTitle.text = context.getDashboardHeader(header).first
        tvHeaderSubtitle.text = context.getDashboardHeader(header).second
        when (header) {
            Header.CONTINUE_READ -> {
                tvHeaderSubtitle.gone()
                clShowMore.gone()
            }
            Header.RELEASE_SOON -> {
                tvHeaderSubtitle.visible()
                clShowMore.gone()
            }
            else -> {
                tvHeaderSubtitle.visible()
                clShowMore.visible()
            }
        }
    }
}

data class TopModel(
    val context: Context,
    val top: Top
) : ViewBindingKotlinModel<ItemListTopBinding>(R.layout.item_list_top) {

    override fun ItemListTopBinding.bind() {
        top.apply {
            tvGreetings.text = greetings
            tvName.text = name
        }
    }
}

data class NewReleaseModel(
    val context: Context,
    val manga: Result
) : ViewBindingKotlinModel<ItemListNewReleaseBinding>(R.layout.item_list_new_release) {

    override fun ItemListNewReleaseBinding.bind() {
        manga.apply {
            tvTitle.text = manga.name
            tvSynopsis.text = manga.synopsis
            Glide.with(context)
                .load(manga.image)
                .into(ivPosterOuter)
            Glide.with(context)
                .load(manga.image)
                .into(ivPosterInner)
            tvGenre.text = manga.genres?.let { Helper.generateMangaGenre(it) }
        }
    }
}

data class ContinueReadModel(
    val context: Context,
    val manga: Result
) : ViewBindingKotlinModel<ItemListContinueReadBinding>(R.layout.item_list_continue_read) {

    override fun ItemListContinueReadBinding.bind() {
        manga.apply {
            tvTitle.text = name
            tvGenre.text = manga.genres?.let { Helper.generateMangaGenre(it) }
            Glide.with(context)
                .load(image)
                .into(ivPoster)
        }
    }
}

data class PopularModel(
    val context: Context,
    val manga: Result
) : ViewBindingKotlinModel<ItemListMangaPopularBinding>(R.layout.item_list_manga_popular) {

    override fun ItemListMangaPopularBinding.bind() {
        manga.apply {
            Glide.with(context)
                .load(image)
                .into(ivPoster)
            tvTitle.text = name
            tvGenre.text = manga.genres?.let { Helper.generateMangaGenre(it) }
        }
    }
}

data class UpdateModel(
    val context: Context,
    val manga: Result
) : ViewBindingKotlinModel<ItemListUpdatedMangaBinding>(R.layout.item_list_updated_manga) {

    override fun ItemListUpdatedMangaBinding.bind() {
        manga.apply {
            Glide.with(context)
                .load(image)
                .into(ivPoster)
            tvTitle.text = name
            tvLastChapter.text = context.getString(R.string.last_chapter, manga.updatedChapter)
            tvGenre.text = manga.genres?.let { Helper.generateMangaGenre(it) }
        }
    }
}

data class ReleaseSoonModel(
    val context: Context,
    val manga: Result
) : ViewBindingKotlinModel<ItemListReleaseSoonBinding>(R.layout.item_list_release_soon) {

    override fun ItemListReleaseSoonBinding.bind() {
        manga.apply {
            Glide.with(context)
                .load(image)
                .into(ivPoster)
            tvTitle.text = name
            tvGenre.text = manga.genres?.let { Helper.generateMangaGenre(it) }
        }
    }
}

