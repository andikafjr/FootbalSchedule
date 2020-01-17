package com.abdhilabs.footbalschedule.ui.search

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.network.ApiRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SearchViewModel : ViewModel() {

    private val listSearch: MutableLiveData<List<Event>> = MutableLiveData()
    private val repo = ApiRepo()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getData(query: String): MutableLiveData<List<Event>> {
        repo.getSearchMatch(query)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                listSearch.postValue(data)
                isLoading.postValue(false)
            }, { error ->
                Log.e("Error Search Match", "${error.message}")
                isLoading.postValue(false)
            })
        return listSearch
    }
}