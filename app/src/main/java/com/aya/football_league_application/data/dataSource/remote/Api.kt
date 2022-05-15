package com.aya.football_league_application.data.dataSource.remote

import com.aya.football_league_application.data.response.HomeResponse
import retrofit2.Call
import retrofit2.http.GET


interface Api {


    @GET(" v2/competitions")
    fun getHome(): Call<HomeResponse>

}