package com.abdhilabs.footbalschedule.searchmatch

import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.network.ApiRepo
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SearchViewModelTest {

    @Mock
    lateinit var repo: ApiRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `fetch valid data`() {
        val listLeague = mutableListOf<Event>()
        val query = ""

        Mockito.`when`(repo.getSearchMatch(query)).thenReturn(Observable.just(listLeague))
    }

}