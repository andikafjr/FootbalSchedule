package com.abdhilabs.footbalschedule.detailmatch

import com.abdhilabs.footbalschedule.model.TeamResponse
import com.abdhilabs.footbalschedule.network.ApiRepo
import com.abdhilabs.footbalschedule.ui.match.previousmatch.PreviousMatchViewModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailMatchViewModelTest {

    private lateinit var viewModel: PreviousMatchViewModel

    @Mock
    lateinit var repo: ApiRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = PreviousMatchViewModel()
    }

    @Test
    fun `fetch valid data`() {
        val listLeague = emptyList<TeamResponse.Team>()
//        val result = viewModel.getData("4328")
//        val response: List<LeagueResponse.LeagueModel>? = null

        Mockito.`when`(repo.getDetailTeamMatch("584435")).thenReturn(Observable.just(listLeague))
//        MatcherAssert.assertThat(listLeague, Matchers.notNull())
//        viewModel.getData("4328")
//        verify(viewModel.getData(), never()).
    }
}