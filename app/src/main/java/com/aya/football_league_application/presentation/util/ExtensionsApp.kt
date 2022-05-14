package com.aya.football_league_application.presentation.util

import com.aya.football_league_application.presentation.ui.MultiDexApp
import com.aya.football_league_application.presentation.util.Constant.LANGUAGE
import java.util.*

fun getAppLanguage(): String = getSharedPrefInstance().getStringValue(LANGUAGE, defaultValue = Locale.getDefault().language)

fun getSharedPrefInstance(): SharedPrefsHelper {
    return if (MultiDexApp.sharedPrefsHelper == null) {
        MultiDexApp.sharedPrefsHelper = SharedPrefsHelper()
        MultiDexApp.sharedPrefsHelper!!
    } else {
        MultiDexApp.sharedPrefsHelper!!
    }
}










