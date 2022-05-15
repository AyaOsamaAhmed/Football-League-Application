package com.aya.football_league_application.presentation.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aya.football_league_application.data.repository.MainRepo

class HomeViewModel : ViewModel() {

    private var retrofitHandler = MainRepo.getInstance()!!
    private var requestLiveData = MutableLiveData<Any>()

    fun responseHome(): LiveData<Any> {
        return  retrofitHandler.requestHome()
    }

    fun requestDetailHome(compitation_id:Int): LiveData<Any> {
        return  retrofitHandler.requestDetailHome(compitation_id)
    }

    fun requestTeams(compitation_id:Int): LiveData<Any> {
        return  retrofitHandler.requestTeams(compitation_id)
    }


}