package com.abdhilabs.footbalschedule.network

import com.abdhilabs.footbalschedule.model.LeagueResponse
import com.abdhilabs.footbalschedule.model.MatchResponse
import com.abdhilabs.footbalschedule.model.SearchResponse
import com.abdhilabs.footbalschedule.model.TeamResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("api/v1/json/1/lookupleague.php")
    fun getDetailLeague(@Query("id") idLeague: String?): Observable<LeagueResponse>

    @GET("api/v1/json/1/eventsnextleague.php")
    fun getListNextMatch(@Query("id") idLeague: String?): Observable<MatchResponse>

    @GET("api/v1/json/1/eventspastleague.php")
    fun getListPreviousMatch(@Query("id") idLeague: String?): Observable<MatchResponse>

    @GET("api/v1/json/1/lookupteam.php")
    fun getDetailTeamMatch(@Query("id") idTeam: String?): Observable<TeamResponse>

    @GET("api/v1/json/1/searchevents.php")
    fun getSearchMatch(@Query("e") query: String?): Observable<SearchResponse>

}