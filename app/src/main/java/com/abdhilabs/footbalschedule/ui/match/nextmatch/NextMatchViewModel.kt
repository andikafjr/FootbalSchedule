package com.abdhilabs.footbalschedule.ui.match.nextmatch

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.network.ApiRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NextMatchViewModel : ViewModel() {

    private val listMatch: MutableLiveData<List<Event>> = MutableLiveData()
    private val repo = ApiRepo()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getData(id: String): MutableLiveData<List<Event>> {
        repo.getNextMatch(idLeague = id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ dataNextMatch ->
                listMatch.postValue(dataNextMatch)
                isLoading.postValue(false)
            }, { error ->
                Log.e("Error Next Match", "${error.message}")
                isLoading.postValue(false)
            })
        return listMatch
    }
}