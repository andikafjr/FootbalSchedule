package com.abdhilabs.footbalschedule.network

import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.model.LeagueResponse
import com.abdhilabs.footbalschedule.model.TeamResponse
import io.reactivex.Observable

class ApiRepo {

    private val api by lazy {
        ApiRetrofit.create()
    }

    fun getLeagueDetail(idLeague: String): Observable<List<LeagueResponse.LeagueModel>> {
        return api.getDetailLeague(idLeague)
            .map { it.dataLeague }
    }

    fun getNextMatch(idLeague: String): Observable<List<Event>> {
        return api.getListNextMatch(idLeague = idLeague)
            .map { it.events }
    }

    fun getPreviousMatch(idLeague: String): Observable<List<Event>> {
        return api.getListPreviousMatch(idLeague = idLeague)
            .map { it.events }
    }

    fun getDetailTeamMatch(idTeam: String): Observable<List<TeamResponse.Team>> {
        return api.getDetailTeamMatch(idTeam = idTeam)
            .map { it.teams }
    }

    fun getSearchMatch(query: String): Observable<List<Event>> {
        return api.getSearchMatch(query)
            .map { it.event.filter { event -> event.strSport.equals("Soccer") } }
    }
}