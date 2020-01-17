package com.abdhilabs.footbalschedule.ui.match.favorite

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abdhilabs.footbalschedule.R
import com.abdhilabs.footbalschedule.model.Favorite
import com.abdhilabs.footbalschedule.ui.match.detail.DetailScheduleActivity
import com.abdhilabs.footbalschedule.utils.*
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_match.*

class FavoriteMatchAdapter(private val favorite: List<Favorite>) :
    RecyclerView.Adapter<FavoriteMatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_match))
    }

    override fun getItemCount(): Int = favorite.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(favorite[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView

        private val tvDate = tv_date_match as TextView
        private val tvHomeTeam = tv_home_team_match as TextView
        private val tvAwayTeam = tv_away_team_match as TextView
        private val tvHomeScore = tv_score_home_team_match as TextView
        private val tvAwayScore = tv_score_away_team_match as TextView

        fun bindItem(event: Favorite) {
            tvDate.text = event.dateEvent?.toDate()
            tvHomeTeam.text = event.strHomeTeam
            tvAwayTeam.text = event.strAwayTeam
            tvHomeScore.text = event.intHomeScore
            tvAwayScore.text = event.intAwayScore

            itemView.setOnClickListener {
                Intent(itemView.context, DetailScheduleActivity::class.java).apply {
                    putExtra("id", "${event.idEvent}")
                    putExtra(KEY_DETAIL_SEARCH, FAVORITE)
                    putExtra(DATA_DETAIL_MATCH, event)
                    itemView.context.startActivity(this)
                }
            }
        }
    }
}