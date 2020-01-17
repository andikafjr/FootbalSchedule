package com.abdhilabs.footbalschedule.model

class DataLeague {

    companion object {
        val league: List<League>
            get() = mutableListOf(
                League(
                    "4328",
                    "English Premier League",
                    "https://www.thesportsdb.com/images/media/league/fanart/o9c14r1547554186.jpg"
                ),
                League(
                    "4329",
                    "English League Championship",
                    "https://www.thesportsdb.com/images/media/league/fanart/tupwvu1422036315.jpg"
                ),
                League(
                    "4330",
                    "Scottish Premier League",
                    "https://www.thesportsdb.com/images/media/league/fanart/wsqyss1422413410.jpg"
                ),
                League(
                    "4331",
                    "German Bundesliga",
                    "https://www.thesportsdb.com/images/media/league/fanart/uststt1422059550.jpg"
                ),
                League(
                    "4332",
                    "Italian Serie A",
                    "https://www.thesportsdb.com/images/media/league/fanart/spqxtv1425356374.jpg"
                ),
                League(
                    "4334",
                    "French Ligue 1",
                    "https://www.thesportsdb.com/images/media/league/fanart/qxvyuv1421448729.jpg"
                ),
                League(
                    "4335",
                    "Spanish La Liga",
                    "https://www.thesportsdb.com/images/media/league/fanart/02gtox1514467274.jpg"
                ),
                League(
                    "4336",
                    "Greek Superleague Greece",
                    "https://www.thesportsdb.com/images/media/league/fanart/vqvtsy1422295448.jpg"
                ),
                League(
                    "4337",
                    "Dutch Eredivisie",
                    "https://www.thesportsdb.com/images/media/league/fanart/rusupv1425356627.jpg"
                ),
                League(
                    "4338",
                    "Belgian Jupiler League",
                    "https://www.thesportsdb.com/images/media/league/fanart/xtpvqu1422244531.jpg"
                )
            )

    }

}