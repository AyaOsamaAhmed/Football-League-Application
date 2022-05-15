package com.aya.football_league_application.data.response

import com.google.gson.annotations.SerializedName

data class DataTeams (

    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("area")
    val area: AreaResponse? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("shortName")
    val shortName: String? = null,


    @field:SerializedName("tla")
    val tla: String? = null,

    @field:SerializedName("crestUrl")
    val crestUrl: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("phone")
    val phone: String? = null,

    @field:SerializedName("website")
    val website: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("founded")
    val founded: String? = null,

    @field:SerializedName("clubColors")
    val clubColors: String? = null,

    @field:SerializedName("venue")
    val venue: String? = null,

    @field:SerializedName("lastUpdated")
    val lastUpdated: String? = null

)
