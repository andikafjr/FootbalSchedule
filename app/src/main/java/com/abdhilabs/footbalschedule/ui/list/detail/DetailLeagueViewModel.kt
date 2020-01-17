package com.abdhilabs.footbalschedule.ui.list.detail

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdhilabs.footbalschedule.model.LeagueResponse
import com.abdhilabs.footbalschedule.network.ApiRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailLeagueViewModel : ViewModel() {

    private val detailLeague: MutableLiveData<List<LeagueResponse.LeagueModel>> = MutableLiveData()
    private val repository = ApiRepo()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getData(id: String): MutableLiveData<List<LeagueResponse.LeagueModel>> {
        repository.getLeagueDetail(idLeague = id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ detail ->
                detailLeague.postValue(detail)
                isLoading.postValue(false)
            }, { error ->
                Log.e("Error", "${error.message}")
                isLoading.postValue(false)
            })
        return detailLeague
    }
}