package com.abdhilabs.footbalschedule.ui.match.previousmatch

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.network.ApiRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PreviousMatchViewModel : ViewModel() {
    private val listPreviousMatch: MutableLiveData<List<Event>> = MutableLiveData()
    private val repo = ApiRepo()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getData(id: String): MutableLiveData<List<Event>> {
        repo.getPreviousMatch(idLeague = id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ dataPreviousMatch ->
                listPreviousMatch.postValue(dataPreviousMatch)
                isLoading.postValue(false)
            }, { error ->
                Log.e("Error Previous Match", "${error.message}")
                isLoading.postValue(false)
            })
        return listPreviousMatch
    }
}