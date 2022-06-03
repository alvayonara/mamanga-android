package com.alvayonara.mamanga.feature.ui.recent

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alvayonara.mamanga.common.base.BaseFragment
import com.alvayonara.mamanga.common.base.BaseViewModel
import com.alvayonara.mamanga.feature.databinding.FragmentRecentBinding

class RecentFragment : BaseFragment<FragmentRecentBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentRecentBinding
        get() = FragmentRecentBinding::inflate

    override fun setup() {
        TODO("Not yet implemented")
    }

    override fun inject() {
        TODO("Not yet implemented")
    }

    override fun getViewModel(): BaseViewModel {
        TODO("Not yet implemented")
    }
}