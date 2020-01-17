package com.abdhilabs.footbalschedule.ui.match.nextmatch

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.model.Event
import com.abdhilabs.footbalschedule.ui.match.detail.DetailScheduleActivity
import com.abdhilabs.footbalschedule.utils.*
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_match.*

class NextMatchAdapter(var match: List<Event>) :
    RecyclerView.Adapter<NextMatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_match))
    }

    override fun getItemCount(): Int = match.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(match[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView
        private val tvDate = tv_date_match as TextView
        private val tvHomeTeam = tv_home_team_match as TextView
        private val tvAwayTeam = tv_away_team_match as TextView

        fun bindItem(event: Event) {
            tvDate.text = event.dateEvent?.toDate()
            tvHomeTeam.text = event.strHomeTeam
            tvAwayTeam.text = event.strAwayTeam

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailScheduleActivity::class.java)
                intent.putExtra("id", "${event.idEvent}")
                intent.putExtra(KEY_DETAIL_SEARCH, MATCH)
                intent.putExtra(DATA_DETAIL_MATCH, event)
                itemView.context.startActivity(intent)
            }
        }
    }
}