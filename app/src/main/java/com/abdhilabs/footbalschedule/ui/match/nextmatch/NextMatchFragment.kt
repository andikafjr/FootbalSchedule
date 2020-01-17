package com.abdhilabs.footbalschedule.ui.match.nextmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.utils.*
import kotlinx.android.synthetic.main.fragment_next_match.*

class NextMatchFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var viewModel: NextMatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progress_bar_next_match.visibility = VISIBLE
        viewModel = ViewModelProviders.of(this)[NextMatchViewModel::class.java]

        this.setupSpinner()
    }

    private fun setupSpinner() {
        val adapterSpinner = ArrayAdapter.createFromResource(
            context!!,
            R.array.spinner_league,
            android.R.layout.simple_spinner_item
        )
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_league_next_match.adapter = adapterSpinner
        spinner_league_next_match.onItemSelectedListener = this
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {}

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when (position) {
            0 -> {
                getData(ID_ENGLISH_PREMIER)
            }
            1 -> {
                getData(ID_ENGLISH_LEAGUE_CHAMPIONSHIP)
            }
            2 -> {
                getData(ID_SCOTTISH_PREMIER_LEAGUE)
            }
            3 -> {
                getData(ID_GERMAN_BUNDESLIGA)
            }
            4 -> {
                getData(ID_ITALIAN_SERIES_A)
            }
            5 -> {
                getData(ID_FRENCH_LIGUE_1)
            }
            6 -> {
                getData(ID_SPANISH_LA_LIGA)
            }
            7 -> {
                getData(ID_GREEK_SUPERLEAGUE_GREECE)
            }
            8 -> {
                getData(ID_DUTCH_EREDIVISIE)
            }
            9 -> {
                getData(ID_BELGIAN_JUPILER_LEAGUE)
            }
        }
    }

    private fun getData(id: String) {
        viewModel.getData(id).observe(this, Observer { data ->
            viewModel.isLoading.observe(this, Observer {
                progress_bar_next_match.visibility = if (it) VISIBLE else GONE
            })
            val adapterNextMatch = NextMatchAdapter(data)
            rv_list_next_match.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = adapterNextMatch
            }
        })
    }

}
