package com.abdhilabs.footbalschedule.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.ui.list.ListLeagueFragment
import com.abdhilabs.footbalschedule.ui.match.ScheduleMatchFragment
import com.abdhilabs.footbalschedule.ui.match.favorite.FavoriteFragment
import com.abdhilabs.footbalschedule.ui.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            loadFragment(ListLeagueFragment(), "LeagueFragment")
        }

        bottom_nav_main.setOnNavigationItemSelectedListener(mOnNavigationItem)
    }

    private val mOnNavigationItem = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.item_league -> {
                loadFragment(ListLeagueFragment(), "LeagueFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.item_search -> {
                loadFragment(SearchFragment(), "SearchFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.item_match -> {
                loadFragment(ScheduleMatchFragment(), "MatchFragment")
                return@OnNavigationItemSelectedListener true
            }
            R.id.item_favorite -> {
                loadFragment(FavoriteFragment(), "FavoriteFragment")
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun loadFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_main, fragment, tag)
            .commit()
    }
}
