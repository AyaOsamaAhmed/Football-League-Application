package com.aya.football_league_application.di.components

import com.aya.football_league_application.di.modules.ApiClient
import com.aya.football_league_application.presentation.ui.viewModel.MainActivityViewModel
import com.google.android.datatransport.runtime.dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiClient::class] )
interface controllerComponent {

    fun injectActivity(viewModel: MainActivityViewModel)
}