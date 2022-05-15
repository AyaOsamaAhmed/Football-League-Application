package com.aya.football_league_application.data.response

import com.google.gson.annotations.SerializedName

data class DataCompetitions (

    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("area")
    val area: AreaResponse? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("emblemUrl")
    val emblemUrl: String? = null,

    @field:SerializedName("plan")
    val plan: String? = null,

    @field:SerializedName("currentSeason")
    val currentSeason: CurrentResponse? = null,

    @field:SerializedName("seasons")
    val seasons: ArrayList<SeasonsResponse>? = null,


    @field:SerializedName("numberOfAvailableSeasons")
    val numberOfAvailableSeasons: String? = null,

    @field:SerializedName("lastUpdated")
    val lastUpdated: String? = null

)
