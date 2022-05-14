package com.aya.football_league_application.presentation.ui.viewModel

import androidx.lifecycle.ViewModel
import com.aya.football_league_application.data.dataSource.remote.Api
import com.aya.football_league_application.di.modules.ApiClient

class MainActivityViewModel () : ViewModel() {

    var apiClient: Api = ApiClient.api

    init {


    }



}