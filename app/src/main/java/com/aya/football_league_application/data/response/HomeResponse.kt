package com.aya.football_league_application.data.response

import com.google.gson.annotations.SerializedName

data class HomeResponse (

    @field:SerializedName("competitions")
    var data: ArrayList<DataCompetitions>? = null,

    @field:SerializedName("message")
    val count: Int = 0

)
