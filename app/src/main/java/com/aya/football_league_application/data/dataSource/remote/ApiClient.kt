package com.aya.football_league_application.data.dataSource.remote

import com.aya.football_league_application.presentation.util.Constant.BASE_URL_API
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .client(okHttpClient())
            .baseUrl(BASE_URL_API)
            .build()
    }

    private fun getGson(): Gson {
        return GsonBuilder().setLenient().create()
    }


    private fun okHttpClient(): OkHttpClient {
        var loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val cashSize: Long = (5 * 1024 * 1024).toLong()
      //  val cache = Cache(getAppInstance().cacheDir, cashSize)
        return OkHttpClient.Builder()
        //    .cache(cache)
            .addInterceptor(headersInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun headersInterceptor() = Interceptor { chain ->
        chain.proceed(
            chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json,*/*")

               /* .also {
                    if (isLogin()) {
                        it.addHeader("Authorization", "Bearer "+getApiToken())
                    }
                    it.addHeader("lang", getAppLanguage())
                }*/
                .build()
        )
    }

    val instanceMainApi: Api by lazy {
        retrofitService().create(Api::class.java)
    }

    val retrofit: Retrofit by lazy {
        retrofitService()
    }

}