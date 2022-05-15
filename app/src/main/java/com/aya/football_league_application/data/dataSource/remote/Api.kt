package com.aya.football_league_application.data.dataSource.remote

import com.aya.football_league_application.data.response.DataCompetitions
import com.aya.football_league_application.data.response.HomeResponse
import com.aya.football_league_application.data.response.TeamsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {


    @GET(" v2/competitions")
    fun getHome(): Call<HomeResponse>

     @GET(" v2/competitions/{id}")
    fun getDetailsHome(
         @Path("id") competitionId: Int,
         @Header("X-Auth-Token") apiKey: String  //5c6e31f39a2846d881a3c954f73625a1
    ): Call<DataCompetitions>

    @GET(" v2/competitions/{id}/teams")
    fun getTeams(
        @Path("id") competitionId: Int,
        @Header("X-Auth-Token") apiKey: String
    ): Call<TeamsResponse>

   // https://www.football-data.org/client/register.


}