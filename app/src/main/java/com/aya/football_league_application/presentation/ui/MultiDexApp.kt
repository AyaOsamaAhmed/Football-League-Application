package com.aya.football_league_application.presentation.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.aya.football_league_application.R
import com.aya.football_league_application.presentation.util.SharedPrefsHelper
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

@SuppressLint("StaticFieldLeak")
class MultiDexApp : MultiDexApplication() {

    private var mCurrentActivity: Activity? = null

    override fun onCreate() {
        super.onCreate()
        appInstance = this
        // lock dark mode on app
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        // Set Custom Font
        ViewPump.init(ViewPump.builder().addInterceptor(CalligraphyInterceptor(CalligraphyConfig.Builder().setFontAttrId(
            R.attr.fontPath).build())).build())
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


    companion object {
        private lateinit var appInstance: MultiDexApp
        var sharedPrefsHelper: SharedPrefsHelper? = null

        fun getAppInstance(): MultiDexApp {
            return appInstance
        }

    }


    fun getCurrentActivity(): Activity? {
        return mCurrentActivity
    }

    fun setCurrentActivity(mCurrentActivity: Activity?) {
        this.mCurrentActivity = mCurrentActivity
    }









}