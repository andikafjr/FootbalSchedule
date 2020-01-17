package com.abdhilabs.footbalschedule.ui.list

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.model.League
import com.abdhilabs.footbalschedule.ui.list.detail.DetailLeagueActivity
import com.abdhilabs.footbalschedule.utils.DATA_ID_DETAIL_LEAGUE
import com.abdhilabs.footbalschedule.utils.glideAdapter
import com.abdhilabs.footbalschedule.utils.inflate
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list_league.*

class ListLeagueAdapter(var league: List<League>) :
    RecyclerView.Adapter<ListLeagueAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_list_league))
    }

    override fun getItemCount(): Int = league.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(league[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        private val title = tvTitleListLeague as TextView
        private val img = imgListLeague as ImageView

        fun bindItem(league: League) {
            title.text = league.title
            glideAdapter(itemView, league.img, img)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailLeagueActivity::class.java)
                intent.putExtra(DATA_ID_DETAIL_LEAGUE, league)
                itemView.context.startActivity(intent)
            }
        }

    }
}