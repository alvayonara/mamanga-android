package com.alvayonara.mamanga.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.alvayonara.mamanga.common.utils.Event
import com.alvayonara.mamanga.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    private val _navigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = _navigation

    /**
     * Used to handle navigation from [ViewModel]
     */
    fun navigate(directions: NavDirections) {
        this._navigation.value = Event(NavigationCommand.To(directions))
    }

    /**
     * Used to back to previous fragment from [ViewModel]
     */
    fun navigateBack() {
        this._navigation.value = Event(NavigationCommand.Back)
    }
}