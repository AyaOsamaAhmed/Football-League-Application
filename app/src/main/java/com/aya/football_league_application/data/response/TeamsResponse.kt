package com.aya.football_league_application.data.response

import com.google.gson.annotations.SerializedName

data class TeamsResponse (

    @field:SerializedName("competitions")
    var data: DataCompetitions? = null,

    @field:SerializedName("message")
    val count: Int = 0,

    @field:SerializedName("teams")
    var teams: ArrayList<DataTeams>? = null

)
