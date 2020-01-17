package com.abdhilabs.footbalschedule.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.model.Event
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var viewModel: SearchViewModel
    private lateinit var adapterSearch: SearchMatchAdapter
    private var strQuery: String = ""
    private val listSearch: List<Event> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this)[SearchViewModel::class.java]
        adapterSearch = SearchMatchAdapter(listSearch)
        sv_match.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        strQuery = query
        getSearch(strQuery)
        return false
    }

    private fun getSearch(query: String?) {
        if (query != null) {
            viewModel.getData(strQuery).observe(this, Observer {
                adapterSearch = SearchMatchAdapter(it)
                rv_list_search_match.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = adapterSearch
                }
            })
            viewModel.isLoading.observe(this, Observer {
                progress_bar_search_match.visibility = if (it) VISIBLE else GONE
            })
        }
        adapterSearch.notifyDataSetChanged()
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }
}