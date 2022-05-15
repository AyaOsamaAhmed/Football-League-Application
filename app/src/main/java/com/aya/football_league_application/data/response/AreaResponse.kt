package com.aya.football_league_application.data.response

import com.google.gson.annotations.SerializedName

data class AreaResponse (

    @field:SerializedName("id")
    var id:Int? = null,

    @field:SerializedName("name")
    val name:String? = null,

    @field:SerializedName("countryCode")
    val countryCode:String? = null,

    @field:SerializedName("ensignUrl")
    val ensignUrl:String? = null

)
