package com.aya.football_league_application.data.response

import com.google.gson.annotations.SerializedName

data class SeasonsResponse (

    @field:SerializedName("id")
    val id:Int? = 0,

    @field:SerializedName("startDate")
    val startDate:String? = null,

    @field:SerializedName("endDate")
    val endDate:String? = null,

    @field:SerializedName("currentMatchday")
    val currentMatchday:String? = null,

    @field:SerializedName("winner")
    val winner:WinnerResponse? = null

)