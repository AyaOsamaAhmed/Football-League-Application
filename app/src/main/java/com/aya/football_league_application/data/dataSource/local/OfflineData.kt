package com.aya.football_league_application.data.dataSource.local

import android.content.Context
import java.io.IOException

class OfflineData (val context: Context) {

    private fun getJsonDataFromAsset(fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    private val jsonFileString = getJsonDataFromAsset("getListOfFilesResponse.json")
   // private val listPersonType = object : TypeToken<MovieResponse>() {}.type

   // var movies: MovieResponse = Gson().fromJson(jsonFileString, listPersonType)


}