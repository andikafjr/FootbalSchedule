package com.abdhilabs.footbalschedule.detailleague

import com.abdhilabs.footbalschedule.model.LeagueResponse
import com.abdhilabs.footbalschedule.network.ApiRepo
import com.abdhilabs.footbalschedule.ui.list.detail.DetailLeagueViewModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class DetailLeagueViewModelTest {

    private lateinit var viewModel: DetailLeagueViewModel

    @Mock
    lateinit var repo: ApiRepo

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = DetailLeagueViewModel()
    }

    @Test
    fun `fetch valid data`() {
        val listLeague = emptyList<LeagueResponse.LeagueModel>()
//        val result = viewModel.getData("4328")
        val response: List<LeagueResponse.LeagueModel>? = null

        `when`(repo.getLeagueDetail("4328")).thenReturn(Observable.just(listLeague))
//        MatcherAssert.assertThat(listLeague, Matchers.notNull())
//        viewModel.getData("4328")
//        verify(viewModel.getData(), never()).
    }

}