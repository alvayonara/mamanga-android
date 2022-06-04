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
import com.alvayonara.mamanga.core.data.domain.model.header.Header
import com.alvayonara.mamanga.core.data.domain.model.manga.Result
import com.alvayonara.mamanga.core.data.domain.model.top.Top
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
                .id("top")
                .addTo(this)
        }

        HeaderModel(context, Header.NEW_RELEASE)
            .id("header.new.release")
            .addIf(this._newRelease.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(26, 0, 26, 26, 16))
            .id("new.releases")
            .models(
                this._newRelease.mapIndexed { index, manga ->
                    NewReleaseModel(context, manga)
                        .id("new.release.$index")
                }
            )
            .onBind { _, view, _ ->
                view.linearLayout()
            }
            .addIf(this._newRelease.isNotEmpty(), this)

        HeaderModel(context, Header.CONTINUE_READ)
            .id("header.continue.read")
            .addIf(this._continueRead.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(26, 0, 26, 26, 16))
            .id("continue.read")
            .models(
                this._continueRead.mapIndexed { index, manga ->
                    ContinueReadModel(context, manga)
                        .id("continue.read.$index")
                }
            )
            .onBind { _, view, _ ->
                view.linearLayout()
            }
            .addIf(this._continueRead.isNotEmpty(), this)

        HeaderModel(context, Header.UPDATE)
            .id("header.update")
            .addIf(this._update.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(26, 0, 26, 26, 16))
            .id("update")
            .models(
                this._update.mapIndexed { index, manga ->
                    UpdateModel(context, manga)
                        .id("update.$index")
                }
            )
            .onBind { _, view, _ ->
                view.linearLayout()
            }
            .addIf(this._update.isNotEmpty(), this)

        HeaderModel(context, Header.POPULAR)
            .id("header.popular")
            .addIf(this._mostPopular.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(20, 0, 20, 26, 12))
            .id("most.popular")
            .models(
                this._mostPopular.mapIndexed { index, manga ->
                    PopularModel(context, manga)
                        .id("most.popular.$index")
                }
            )
            .onBind { _, view, _ ->
                view.gridLayout()
            }
            .addIf(this._mostPopular.isNotEmpty(), this)

        HeaderModel(context, Header.RELEASE_SOON)
            .id("header.release.soon")
            .addIf(this._releaseSoon.isNotEmpty(), this)

        CarouselModel_()
            .padding(Carousel.Padding.dp(26, 0, 26, 26, 16))
            .id("release.soon")
            .models(
                this._releaseSoon.mapIndexed { index, manga ->
                    ReleaseSoonModel(context, manga)
                        .id("release.soon.$index")
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
        var headerTitle = ""
        var headerSubtitle = ""
        when (header) {
            Header.NEW_RELEASE -> {
                headerTitle = "New Release!"
                headerSubtitle = "Read the latest manga recommendations"
            }
            Header.CONTINUE_READ -> headerTitle = "Continue Reading"
            Header.UPDATE -> {
                headerTitle = "Update Manga"
                headerSubtitle = "Don't miss this week's update"
            }
            Header.POPULAR -> {
                headerTitle = "Most Popular Manga"
                headerSubtitle = "Lots of interesting manga here"
            }
            Header.RELEASE_SOON -> {
                headerTitle = "Release Soon!"
                headerSubtitle = "Keep watching, wait for the latest manga"
            }
        }

        tvHeaderTitle.text = headerTitle
        tvHeaderSubtitle.text = headerSubtitle

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

            var genre = ""
            manga.genres.forEach {
                genre += it.name
            }
            tvGenre.text = genre
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

            var genre = ""
            genres.forEach {
                genre += it.name
            }
            tvGenre.text = genre

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

            var genre = ""
            genres.forEach {
                genre += it.name
            }
            tvGenre.text = genre
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

            tvLastChapter.text = "Ch. ${updated_chapter}"

            var genre = ""
            genres.forEach {
                genre += it.name
            }
            tvGenre.text = genre
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

            var genre = ""
            genres.forEach {
                genre += it.name
            }
            tvGenre.text = genre
        }
    }
}

