package com.abdhilabs.footbalschedule.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.abdhilabs.footbalschedule.ui.match.nextmatch.NextMatchFragment
import com.abdhilabs.footbalschedule.ui.match.previousmatch.PreviousMatchFragment

class PagerMatchAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> NextMatchFragment()
            else -> PreviousMatchFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Next Match"
            else -> "Previous Match"
        }
    }
}