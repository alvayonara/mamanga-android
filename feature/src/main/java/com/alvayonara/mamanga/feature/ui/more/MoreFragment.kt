package com.alvayonara.mamanga.feature.ui.more

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alvayonara.mamanga.common.base.BaseFragment
import com.alvayonara.mamanga.common.base.BaseViewModel
import com.alvayonara.mamanga.feature.databinding.FragmentMoreBinding

class MoreFragment : BaseFragment<FragmentMoreBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMoreBinding
        get() = FragmentMoreBinding::inflate

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