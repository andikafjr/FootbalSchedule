package com.abdhilabs.footbalschedule.model

import com.google.gson.annotations.SerializedName

data class LeagueResponse(

    @SerializedName("leagues")
    var dataLeague: List<LeagueModel>
) {
    data class LeagueModel(
        @SerializedName("dateFirstEvent")
        val dateFirstEvent: String,
        @SerializedName("idCup")
        val idCup: String,
        @SerializedName("idLeague")
        val idLeague: String,
        @SerializedName("idSoccerXML")
        val idSoccerXML: String,
        @SerializedName("intFormedYear")
        val intFormedYear: String,
        @SerializedName("strBadge")
        val strBadge: String,
        @SerializedName("strBanner")
        val strBanner: String,
        @SerializedName("strComplete")
        val strComplete: Any,
        @SerializedName("strCountry")
        val strCountry: String,
        @SerializedName("strDescriptionCN")
        val strDescriptionCN: Any,
        @SerializedName("strDescriptionDE")
        val strDescriptionDE: Any,
        @SerializedName("strDescriptionEN")
        val strDescriptionEN: String,
        @SerializedName("strDescriptionES")
        val strDescriptionES: Any,
        @SerializedName("strDescriptionFR")
        val strDescriptionFR: String,
        @SerializedName("strDescriptionHU")
        val strDescriptionHU: Any,
        @SerializedName("strDescriptionIL")
        val strDescriptionIL: Any,
        @SerializedName("strDescriptionIT")
        val strDescriptionIT: Any,
        @SerializedName("strDescriptionJP")
        val strDescriptionJP: Any,
        @SerializedName("strDescriptionNL")
        val strDescriptionNL: Any,
        @SerializedName("strDescriptionNO")
        val strDescriptionNO: Any,
        @SerializedName("strDescriptionPL")
        val strDescriptionPL: Any,
        @SerializedName("strDescriptionPT")
        val strDescriptionPT: Any,
        @SerializedName("strDescriptionRU")
        val strDescriptionRU: Any,
        @SerializedName("strDescriptionSE")
        val strDescriptionSE: Any,
        @SerializedName("strDivision")
        val strDivision: String,
        @SerializedName("strFacebook")
        val strFacebook: String,
        @SerializedName("strFanart1")
        val strFanart1: String,
        @SerializedName("strFanart2")
        val strFanart2: String,
        @SerializedName("strFanart3")
        val strFanart3: String,
        @SerializedName("strFanart4")
        val strFanart4: String,
        @SerializedName("strGender")
        val strGender: String,
        @SerializedName("strLeague")
        val strLeague: String,
        @SerializedName("strLeagueAlternate")
        val strLeagueAlternate: String,
        @SerializedName("strLocked")
        val strLocked: String,
        @SerializedName("strLogo")
        val strLogo: String,
        @SerializedName("strNaming")
        val strNaming: String,
        @SerializedName("strPoster")
        val strPoster: Any,
        @SerializedName("strRSS")
        val strRSS: String,
        @SerializedName("strSport")
        val strSport: String,
        @SerializedName("strTrophy")
        val strTrophy: String,
        @SerializedName("strTwitter")
        val strTwitter: String,
        @SerializedName("strWebsite")
        val strWebsite: String,
        @SerializedName("strYoutube")
        val strYoutube: String
    )
}