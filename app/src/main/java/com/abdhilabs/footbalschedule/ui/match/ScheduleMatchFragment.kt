package com.abdhilabs.footbalschedule.ui.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.adapter.PagerMatchAdapter
import kotlinx.android.synthetic.main.fragment_schedule_match.*

class ScheduleMatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragmentAdapter = PagerMatchAdapter(childFragmentManager)
        view_pager_match.adapter = fragmentAdapter

        tab_layout_match.setupWithViewPager(view_pager_match)
    }

}
