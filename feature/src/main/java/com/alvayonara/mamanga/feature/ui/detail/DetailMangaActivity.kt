package com.alvayonara.mamanga.feature.ui.detail

import android.view.LayoutInflater
import com.alvayonara.mamanga.common.base.BaseActivity
import com.alvayonara.mamanga.feature.databinding.ActivityDetailMangaBinding

class DetailMangaActivity : BaseActivity<ActivityDetailMangaBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityDetailMangaBinding
        get() = ActivityDetailMangaBinding::inflate

    override fun setup() {

    }

    override fun inject() {

    }
}