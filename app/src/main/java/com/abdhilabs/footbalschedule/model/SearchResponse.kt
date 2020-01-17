package com.abdhilabs.footbalschedule.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("event")
    val event: List<Event>
)
