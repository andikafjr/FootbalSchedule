package com.abdhilabs.footbalschedule.ui.match.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.db.database
import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.model.Favorite
import com.abdhilabs.footbalschedule.utils.*
import kotlinx.android.synthetic.main.activity_detail_schedule.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class DetailScheduleActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailScheduleViewModel

    private var menuItem: Menu? = null
    private var isFavorite: Boolean = false
    private lateinit var data: Event
    private lateinit var dataFav: Favorite
    private lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_schedule)
        supportActionBar?.title = "Match Detail"

        viewModel = ViewModelProviders.of(this)[DetailScheduleViewModel::class.java]
        id = intent.getStringExtra("id")
        favoriteState()
        when (intent.getStringExtra(KEY_DETAIL_SEARCH)) {
            MATCH -> {
                data = intent.getParcelableExtra(DATA_DETAIL_MATCH)!!
                viewModel.getBadgeHome(data.idHomeTeam!!).observe(this, Observer { data ->
                    viewModel.isLoading.observe(this, Observer {
                        progress_bar_img_home_team.visibility = if (it) VISIBLE else GONE
                    })
                    glideActivity(this, data[0].strTeamBadge, img_logo_home_detail_schedule)
                })
                viewModel.getBadgeAway(data.idAwayTeam!!).observe(this, Observer { data ->
                    viewModel.isLoading.observe(this, Observer {
                        progress_bar_img_away_team.visibility = if (it) VISIBLE else GONE
                    })
                    glideActivity(this, data[0].strTeamBadge, img_logo_away_detail_schedule)
                })
                setupView(data)
            }
            RESULT -> {
                data = intent.getParcelableExtra(DATA_DETAIL_MATCH)
                viewModel.getBadgeHome(data.idHomeTeam!!).observe(this, Observer { data ->
                    viewModel.isLoading.observe(this, Observer {
                        progress_bar_img_home_team.visibility = if (it) VISIBLE else GONE
                    })
                    glideActivity(this, data[0].strTeamBadge, img_logo_home_detail_schedule)
                })
                viewModel.getBadgeAway(data.idAwayTeam!!).observe(this, Observer { data ->
                    viewModel.isLoading.observe(this, Observer {
                        progress_bar_img_away_team.visibility = if (it) VISIBLE else GONE
                    })
                    glideActivity(this, data[0].strTeamBadge, img_logo_away_detail_schedule)
                })
                setupView(data)
            }
            FAVORITE -> {
                dataFav = intent.getParcelableExtra(DATA_DETAIL_MATCH)
                viewModel.getBadgeHome(dataFav.idHomeTeam!!).observe(this, Observer { data ->
                    viewModel.isLoading.observe(this, Observer {
                        progress_bar_img_home_team.visibility = if (it) VISIBLE else GONE
                    })
                    glideActivity(this, data[0].strTeamBadge, img_logo_home_detail_schedule)
                })
                viewModel.getBadgeAway(dataFav.idAwayTeam!!).observe(this, Observer { data ->
                    viewModel.isLoading.observe(this, Observer {
                        progress_bar_img_away_team.visibility = if (it) VISIBLE else GONE
                    })
                    glideActivity(this, data[0].strTeamBadge, img_logo_away_detail_schedule)
                })
                setupViewFav(dataFav)
            }
        }
    }

    private fun favoriteState() {
        database.use {
            val result = select(Favorite.TABLE_FAVORITE)
                .whereArgs(
                    "(MATCH_ID = {id})",
                    "id" to id
                )
            val favorite = result.parseList(classParser<Favorite>())
            if (favorite.isNotEmpty()) isFavorite = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menuItem = menu
        setFavorite()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            R.id.add_to_favorite -> {
                if (isFavorite) viewModel.removeFromFavorite(this, id) else viewModel.addToFavorite(
                    this,
                    data
                )

                isFavorite = !isFavorite
                setFavorite()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun setFavorite() {
        if (isFavorite)
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon =
                ContextCompat.getDrawable(this, R.drawable.ic_add_to_favorites)
    }

    private fun setupView(data: Event) {
        tv_date_match_detail_schedule.text = data.dateEvent?.toDate()
        tv_home_team_name_detail_schedule.text = data.strHomeTeam
        tv_away_team_name_detail_schedule.text = data.strAwayTeam
        tv_score_home_detail_schedule.text = data.intHomeScore
        tv_score_away_detail_schedule.text = data.intAwayScore
        tv_home_goals_detail_schedule.text = data.strHomeGoalDetails
        tv_away_goals_detail_schedule.text = data.strAwayGoalDetails
        tv_home_shots_detail_schedule.text = data.intHomeShots
        tv_away_shots_detail_schedule.text = data.intAwayShots
        tv_home_goalkeeper_detail_schedule.text = data.strHomeLineupGoalkeeper
        tv_away_goalkeeper_detail_schedule.text = data.strAwayLineupGoalkeeper
        tv_home_defense_detail_schedule.text = data.strHomeLineupDefense
        tv_away_defense_detail_schedule.text = data.strAwayLineupDefense
        tv_home_midfield_detail_schedule.text = data.strHomeLineupMidfield
        tv_away_midfield_detail_schedule.text = data.strAwayLineupMidfield
        tv_home_forward_detail_schedule.text = data.strHomeLineupForward
        tv_away_forward_detail_schedule.text = data.strAwayLineupForward
    }

    private fun setupViewFav(data: Favorite) {
        tv_date_match_detail_schedule.text = data.dateEvent?.toDate()
        tv_home_team_name_detail_schedule.text = data.strHomeTeam
        tv_away_team_name_detail_schedule.text = data.strAwayTeam
        tv_score_home_detail_schedule.text = data.intHomeScore
        tv_score_away_detail_schedule.text = data.intAwayScore
        tv_home_goals_detail_schedule.text = data.strHomeGoalDetails
        tv_away_goals_detail_schedule.text = data.strAwayGoalDetails
        tv_home_shots_detail_schedule.text = data.intHomeShots
        tv_away_shots_detail_schedule.text = data.intAwayShots
        tv_home_goalkeeper_detail_schedule.text = data.strHomeLineupGoalkeeper
        tv_away_goalkeeper_detail_schedule.text = data.strAwayLineupGoalkeeper
        tv_home_defense_detail_schedule.text = data.strHomeLineupDefense
        tv_away_defense_detail_schedule.text = data.strAwayLineupDefense
        tv_home_midfield_detail_schedule.text = data.strHomeLineupMidfield
        tv_away_midfield_detail_schedule.text = data.strAwayLineupMidfield
        tv_home_forward_detail_schedule.text = data.strHomeLineupForward
        tv_away_forward_detail_schedule.text = data.strAwayLineupForward
    }
}
