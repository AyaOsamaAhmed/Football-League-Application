package com.aya.football_league_application.data.repository

import androidx.lifecycle.MutableLiveData
import com.aya.football_league_application.data.dataSource.remote.Api
import com.aya.football_league_application.data.dataSource.remote.ApiClient
import com.aya.football_league_application.data.response.HomeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {


    private var instanceMainApi: Api = ApiClient.instanceMainApi

    companion object {
        private var retrofitMain: MainRepo? = null

        @Synchronized
        fun getInstance(): MainRepo? {
            if (retrofitMain == null) {
                retrofitMain = MainRepo()
            }
            return retrofitMain
        }
    }


    fun requestHome(): MutableLiveData<Any> {
        val requestLiveData = MutableLiveData<Any>()
        instanceMainApi.getHome()
            .enqueue(object : Callback<HomeResponse> {
                override fun onResponse(
                    call: Call<HomeResponse>,
                    response: Response<HomeResponse>
                ) {
                    when {
                        response.isSuccessful -> {
                            requestLiveData.value = response.body()
                        }
                        response.code() == 401 -> {
                            requestLiveData.value = response.code()

                        }
                        response.code() == 404 -> {
                            requestLiveData.value = response.code()

                        }
                        response.code() == 422 -> {
                            requestLiveData.value = response.message()

                        }
                        else -> {
                            requestLiveData.value = response.message()
                        }
                    }
                }

                override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                    requestLiveData.value = t
                 }

            })
        return requestLiveData

    }


   }