package com.alvayonara.mamanga.feature.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alvayonara.mamanga.common.model.manga.Result
import com.alvayonara.mamanga.core.domain.usecase.dashboard.DashboardUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DashboardViewModel constructor(private val dashboardUseCase: DashboardUseCase) : ViewModel() {

    private val _compositeDisposable by lazy { CompositeDisposable() }

    private val _dashboard: MutableLiveData<DashboardUIState> =
        MutableLiveData()
    val dashboard: MutableLiveData<DashboardUIState> get() = _dashboard

    init {
        getManga()
    }

    fun getManga() {
        _compositeDisposable.add(dashboardUseCase.getNewRelease()
            .doOnSubscribe { _dashboard.postValue(DashboardUIState.ShowLoading) }
            .doOnNext { _dashboard.postValue(DashboardUIState.NewReleaseResult(it)) }
            .subscribeOn(Schedulers.io())
            .flatMap {
                dashboardUseCase.getUpdateManga()
                    .doOnNext { _dashboard.postValue(DashboardUIState.UpdateMangaResult(it)) }
            }
            .flatMap {
                dashboardUseCase.getMostPopular()
                    .doOnNext { _dashboard.postValue(DashboardUIState.PopularMangaResult(it)) }
            }
            .flatMap {
                dashboardUseCase.getReleaseSoon()
                    .doOnNext { _dashboard.postValue(DashboardUIState.ReleaseSoonResult(it)) }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _dashboard.value = DashboardUIState.ShowContent
            }, {
                _dashboard.value = DashboardUIState.ShowError(it)
            })
        )
    }

    sealed class DashboardUIState {
        object ShowContent : DashboardUIState()
        object ShowLoading : DashboardUIState()
        data class ShowError(val error: Throwable) : DashboardUIState()
        data class NewReleaseResult(val model: List<Result>) : DashboardUIState()
        data class UpdateMangaResult(val model: List<Result>) : DashboardUIState()
        data class PopularMangaResult(val model: List<Result>) : DashboardUIState()
        data class ReleaseSoonResult(val model: List<Result>) : DashboardUIState()
    }

    override fun onCleared() {
        super.onCleared()
        _compositeDisposable.dispose()
    }
}