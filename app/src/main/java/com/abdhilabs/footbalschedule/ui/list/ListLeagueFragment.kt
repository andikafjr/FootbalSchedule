package com.abdhilabs.footbalschedule.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.model.DataLeague
import kotlinx.android.synthetic.main.fragment_list_league.*

class ListLeagueFragment : Fragment() {

    var listLeague = DataLeague.league

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_league, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterListLeague = ListLeagueAdapter(listLeague)
        rv_list_league.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterListLeague
            setHasFixedSize(true)
        }

    }
}
