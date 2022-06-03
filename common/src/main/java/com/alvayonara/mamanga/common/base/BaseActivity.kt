package com.alvayonara.mamanga.common.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setup()
    }

    abstract fun setup()
    abstract fun inject()

    protected fun getBundle() = intent.extras

    protected open fun setupView() {}
    protected open fun setupRecyclerView() {}
    protected open fun subscribeViewModel() {}
    protected open fun releaseAdapter() {}

    override fun onDestroy() {
        super.onDestroy()
        releaseAdapter()
        _binding = null
    }
}