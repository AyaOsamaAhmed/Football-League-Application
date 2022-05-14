package com.aya.football_league_application.presentation.ui.activity

import android.os.Bundle
import com.aya.football_league_application.R
import com.aya.football_league_application.presentation.ui.AppBaseActivity

class MainActivity : AppBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}