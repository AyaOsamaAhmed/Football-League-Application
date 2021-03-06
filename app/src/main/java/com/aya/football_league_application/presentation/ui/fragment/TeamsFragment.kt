package com.aya.football_league_application.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aya.football_league_application.data.response.HomeResponse
import com.aya.football_league_application.data.response.TeamsResponse
import com.aya.football_league_application.databinding.FragmentHomeBinding
import com.aya.football_league_application.databinding.FragmentTeamBinding
import com.aya.football_league_application.presentation.ui.activity.MainActivity
import com.aya.football_league_application.presentation.ui.adapter.AdapterHome
import com.aya.football_league_application.presentation.ui.adapter.AdapterTeam
import com.aya.football_league_application.presentation.ui.viewModel.HomeViewModel
import com.aya.football_league_application.presentation.util.hide
import com.aya.football_league_application.presentation.util.show

class TeamsFragment : Fragment() {

    private lateinit var binding : FragmentTeamBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTeamBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        getTeamsResponse(2000)

        return  binding.root
    }


    private fun getTeamsResponse(id:Int){
        progressView(true)

        binding.apply {
            lyNoHaveData.hide()
            viewModel.requestTeams(id)
                .observe(viewLifecycleOwner){
                    progressView(false)
                    when(it){
                        is TeamsResponse -> {
                                it.teams.let { data ->
                                    if (data != null){
                                        adapterTeam = AdapterTeam(data)
                                    }else{
                                        lyNoHaveData.show()
                                    }} } } }
                }
        }

    private fun progressView(enable : Boolean ){
        val progress =  (activity as MainActivity).getProgressBarInstance()
        if (enable){
            progress.show()
        }else{
            progress.dismiss()
        }
    }

}