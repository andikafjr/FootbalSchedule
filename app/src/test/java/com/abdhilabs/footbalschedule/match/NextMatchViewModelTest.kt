package com.abdhilabs.footbalschedule.match

import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.network.ApiRepo
import com.abdhilabs.footbalschedule.ui.match.nextmatch.NextMatchViewModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class NextMatchViewModelTest {

    private lateinit var viewModel: NextMatchViewModel

    @Mock
    lateinit var repo: ApiRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = NextMatchViewModel()
    }

    @Test
    fun `fetch valid data`() {
        val listLeague = mutableListOf<Event>()
//        val result = viewModel.getData("4328")
//        val response: List<LeagueResponse.LeagueModel>? = null

        Mockito.`when`(repo.getNextMatch("4335")).thenReturn(Observable.just(listLeague))
//        MatcherAssert.assertThat(listLeague, Matchers.notNull())
//        viewModel.getData("4328")
//        verify(viewModel.getData(), never()).
    }
}