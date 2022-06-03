package com.alvayonara.mamanga.feature.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alvayonara.mamanga.common.base.BaseFragment
import com.alvayonara.mamanga.common.base.BaseViewModel
import com.alvayonara.mamanga.feature.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDashboardBinding
        get() = FragmentDashboardBinding::inflate

    override fun setup() {

    }

    override fun inject() {
    }

    override fun getViewModel(): BaseViewModel {
        TODO("Not yet implemented")
    }
}