package com.aya.football_league_application.di.modules

import com.aya.football_league_application.data.dataSource.remote.Api
import com.aya.football_league_application.presentation.util.Constant.BASE_URL_API
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

// @Module informs Dagger that this class is a Dagger Module
@Module
object ApiClient {

    // @Provides tell Dagger how to create instances of the type that this function
    @Singleton
    @Provides
     fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gSon()))
            .client(okHttpClient())
            .baseUrl(BASE_URL_API)
            .build()
    }

    @Singleton
    @Provides
     fun okHttpClient(): OkHttpClient {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val cashSize: Long = (5 * 1024 * 1024).toLong()
     //   val cache = Cache(application.cacheDir, cashSize)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
         //   .cache(cache)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(headersInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Singleton
    @Provides
     fun headersInterceptor() = Interceptor { chain ->
        chain.proceed(
            chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json,*/*")
                .build()
        )
    }

    @Singleton
    @Provides
     fun gSon (): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    val api: Api by lazy {
        retrofitService().create(Api::class.java)
    }


    val retrofit: Retrofit by lazy {
        retrofitService()
    }

}