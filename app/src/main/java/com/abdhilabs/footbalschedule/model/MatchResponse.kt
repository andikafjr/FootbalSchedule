package com.abdhilabs.footbalschedule.model

import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("events")
    var events: List<Event>
)