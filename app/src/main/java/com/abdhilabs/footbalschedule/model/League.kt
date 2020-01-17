package com.abdhilabs.footbalschedule.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class League(
    var id: String = "",
    var title: String = "",
    var img: String = ""
) : Parcelable