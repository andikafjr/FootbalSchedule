package com.abdhilabs.footbalschedule.ui.list.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.model.League
import com.abdhilabs.footbalschedule.model.LeagueResponse
import com.abdhilabs.footbalschedule.utils.DATA_ID_DETAIL_LEAGUE
import com.abdhilabs.footbalschedule.utils.glideActivity
import kotlinx.android.synthetic.main.activity_detail_league.*

class DetailLeagueActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailLeagueViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_league)

        val league = intent.getParcelableExtra<League>(DATA_ID_DETAIL_LEAGUE)

        viewModel = ViewModelProviders.of(this)[DetailLeagueViewModel::class.java]

        viewModel.getData(league.id).observe(this, Observer {
            dataDetail(it[0])
        })

        viewModel.isLoading.observe(this, Observer {
            progressBar.visibility = if (it) VISIBLE else GONE
        })
    }

    @SuppressLint("SetTextI18n")
    private fun dataDetail(leagueModel: LeagueResponse.LeagueModel) {
        glideActivity(this, leagueModel.strFanart1, img_banner_detail_league)
        tv_title_detail_league.text = leagueModel.strLeague
        tv_date_detail_league.text = getString(R.string.tv_date_detail, leagueModel.dateFirstEvent)
        tv_gender_detail_league.text = getString(R.string.tv_gender_detail, leagueModel.strGender)
        tv_country_detail_league.text =
            getString(R.string.tv_country_detail, leagueModel.strCountry)
        tv_desc_detail_league.text = leagueModel.strDescriptionEN
    }

}
