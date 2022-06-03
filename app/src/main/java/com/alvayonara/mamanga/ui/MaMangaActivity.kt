package com.alvayonara.mamanga.ui

import android.view.LayoutInflater
import com.alvayonara.mamanga.common.base.BaseActivity
import com.alvayonara.mamanga.databinding.ActivityMamangaBinding

class MaMangaActivity : BaseActivity<ActivityMamangaBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityMamangaBinding
        get() = ActivityMamangaBinding::inflate

    override fun setup() {

    }

    override fun inject() { }
}