package com.abdhilabs.footbalschedule.ui.match.detail

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abdhilabs.footbalschedule.db.database
import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.model.Favorite
import com.abdhilabs.footbalschedule.model.TeamResponse
import com.abdhilabs.footbalschedule.network.ApiRepo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert

class DetailScheduleViewModel : ViewModel() {

    private val dataTeamHome: MutableLiveData<List<TeamResponse.Team>> = MutableLiveData()
    private val dataTeamAway: MutableLiveData<List<TeamResponse.Team>> = MutableLiveData()
    private val repository = ApiRepo()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getBadgeHome(id: String): MutableLiveData<List<TeamResponse.Team>> {
        repository.getDetailTeamMatch(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ team ->
                dataTeamHome.postValue(team)
                isLoading.postValue(false)
            }, { error ->
                Log.e("Error Detail Schedule", "${error.message}")
                isLoading.postValue(false)
            })
        return dataTeamHome
    }

    @SuppressLint("CheckResult")
    fun getBadgeAway(id: String): MutableLiveData<List<TeamResponse.Team>> {
        repository.getDetailTeamMatch(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ team ->
                dataTeamAway.postValue(team)
                isLoading.postValue(false)
            }, { error ->
                Log.e("Error Detail Schedule", "${error.message}")
                isLoading.postValue(false)
            })
        return dataTeamAway
    }

    fun addToFavorite(ctx: Context, data: Event) {
        try {
            ctx.database.use {
                insert(
                    Favorite.TABLE_FAVORITE,
                    Favorite.MATCH_ID to data.idEvent,
                    Favorite.MATCH_NAME to data.strEvent,
                    Favorite.MATCH_DATE to data.dateEvent,
                    Favorite.MATCH_ID_HOME to data.idHomeTeam,
                    Favorite.MATCH_ID_AWAY to data.idAwayTeam,
                    Favorite.MATCH_HOME_NAME to data.strHomeTeam,
                    Favorite.MATCH_AWAY_NAME to data.strAwayTeam,
                    Favorite.MATCH_HOME_SCORE to data.intHomeScore,
                    Favorite.MATCH_AWAY_SCORE to data.intAwayScore,
                    Favorite.MATCH_HOME_GOALS to data.strHomeGoalDetails,
                    Favorite.MATCH_AWAY_GOALS to data.strAwayGoalDetails,
                    Favorite.MATCH_HOME_SHOTS to data.intHomeShots,
                    Favorite.MATCH_AWAY_SHOTS to data.intAwayShots,
                    Favorite.MATCH_HOME_GOALKEEPER to data.strHomeLineupGoalkeeper,
                    Favorite.MATCH_AWAY_GOALKEEPER to data.strAwayLineupGoalkeeper,
                    Favorite.MATCH_HOME_DEFENSE to data.strHomeLineupDefense,
                    Favorite.MATCH_AWAY_DEFENSE to data.strAwayLineupDefense,
                    Favorite.MATCH_HOME_MIDFIELD to data.strHomeLineupMidfield,
                    Favorite.MATCH_AWAY_MIDFIELD to data.strAwayLineupMidfield,
                    Favorite.MATCH_HOME_FORWARD to data.strHomeLineupForward,
                    Favorite.MATCH_AWAY_FORWARD to data.strAwayLineupForward
                )
            }
            Toast.makeText(ctx, "You add to Favorite", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException) {
            Toast.makeText(ctx, "${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    fun removeFromFavorite(ctx: Context, id: String) {
        try {
            ctx.database.use {
                delete(
                    Favorite.TABLE_FAVORITE, "(MATCH_ID = {id})",
                    "id" to id
                )
            }
            Toast.makeText(ctx, "You remove from Favorite", Toast.LENGTH_SHORT).show()
        } catch (e: SQLiteConstraintException) {
            Toast.makeText(ctx, e.localizedMessage, Toast.LENGTH_SHORT).show()
        }
    }
}