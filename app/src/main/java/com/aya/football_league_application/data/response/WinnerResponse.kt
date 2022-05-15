package com.aya.football_league_application.data.response

import com.google.gson.annotations.SerializedName

data class WinnerResponse (
    @field:SerializedName("id")
    var id:Int? = null,

    val name: String,
    val shortName: String ,
    val tla: String ,
    val crestUrl: String
        )