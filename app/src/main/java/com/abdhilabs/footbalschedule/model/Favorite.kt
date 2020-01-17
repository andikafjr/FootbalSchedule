package com.abdhilabs.footbalschedule.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Favorite(
    val id: Long?,
    val idEvent: String?,
    val strEvent: String?,
    val dateEvent: String?,
    val idHomeTeam: String?,
    val idAwayTeam: String?,
    val strHomeTeam: String?,
    val strAwayTeam: String?,
    val intHomeScore: String?,
    val intAwayScore: String?,
    val strHomeGoalDetails: String?,
    val strAwayGoalDetails: String?,
    val intHomeShots: String?,
    val intAwayShots: String?,
    val strHomeLineupGoalkeeper: String?,
    val strAwayLineupGoalkeeper: String?,
    val strHomeLineupDefense: String?,
    val strAwayLineupDefense: String?,
    val strHomeLineupMidfield: String?,
    val strAwayLineupMidfield: String?,
    val strHomeLineupForward: String?,
    val strAwayLineupForward: String?
) : Parcelable {
    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"

        const val MATCH_ID: String = "MATCH_ID"
        const val MATCH_NAME: String = "MATCH_NAME"
        const val MATCH_DATE: String = "MATCH_DATE"
        const val MATCH_ID_HOME: String = "MATCH_ID_HOME"
        const val MATCH_HOME_NAME: String = "MATCH_HOME_NAME"
        const val MATCH_HOME_SCORE: String = "MATCH_HOME_SCORE"
        const val MATCH_HOME_GOALS: String = "MATCH_HOME_GOALS"
        const val MATCH_HOME_SHOTS: String = "MATCH_HOME_SHOTS"
        const val MATCH_HOME_GOALKEEPER: String = "MATCH_HOME_GOALKEEPER"
        const val MATCH_HOME_DEFENSE: String = "MATCH_HOME_DEFENSE"
        const val MATCH_HOME_MIDFIELD: String = "MATCH_HOME_MIDFIELD"
        const val MATCH_HOME_FORWARD: String = "MATCH_HOME_FORWARD"

        const val MATCH_ID_AWAY: String = "MATCH_ID_AWAY"
        const val MATCH_AWAY_NAME: String = "MATCH_AWAY_NAME"
        const val MATCH_AWAY_SCORE: String = "MATCH_AWAY_SCORE"
        const val MATCH_AWAY_GOALS: String = "MATCH_AWAY_GOALS"
        const val MATCH_AWAY_SHOTS: String = "MATCH_AWAY_SHOTS"
        const val MATCH_AWAY_GOALKEEPER: String = "MATCH_AWAY_GOALKEEPER"
        const val MATCH_AWAY_DEFENSE: String = "MATCH_AWAY_DEFENSE"
        const val MATCH_AWAY_MIDFIELD: String = "MATCH_AWAY_MIDFIELD"
        const val MATCH_AWAY_FORWARD: String = "MATCH_AWAY_FORWARD"
    }
}