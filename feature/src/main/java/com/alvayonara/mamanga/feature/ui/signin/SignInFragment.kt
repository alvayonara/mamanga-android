package com.alvayonara.mamanga.feature.ui.signin

import android.view.LayoutInflater
import android.view.ViewGroup
import com.alvayonara.mamanga.common.base.BaseFragment
import com.alvayonara.mamanga.common.base.BaseViewModel
import com.alvayonara.mamanga.feature.databinding.FragmentSignInBinding

class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSignInBinding
        get() = FragmentSignInBinding::inflate

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