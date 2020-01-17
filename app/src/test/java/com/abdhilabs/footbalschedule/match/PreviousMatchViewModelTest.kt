package com.abdhilabs.footbalschedule.match

import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.network.ApiRepo
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class PreviousMatchViewModelTest {

    @Mock
    lateinit var repo: ApiRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `fetch valid data`() {
        val listLeague = emptyList<Event>()

        Mockito.`when`(repo.getPreviousMatch("4335")).thenReturn(Observable.just(listLeague))
    }
}