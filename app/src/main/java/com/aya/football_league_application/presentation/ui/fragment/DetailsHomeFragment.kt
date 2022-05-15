package com.aya.football_league_application.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.aya.football_league_application.R
import com.aya.football_league_application.data.response.DataCompetitions
import com.aya.football_league_application.data.response.HomeResponse
import com.aya.football_league_application.databinding.FragmentDetailsHomeBinding
import com.aya.football_league_application.databinding.FragmentHomeBinding
import com.aya.football_league_application.presentation.ui.activity.MainActivity
import com.aya.football_league_application.presentation.ui.adapter.AdapterHome
import com.aya.football_league_application.presentation.ui.adapter.AdapterSeasons
import com.aya.football_league_application.presentation.ui.interfaces.onClick
import com.aya.football_league_application.presentation.ui.viewModel.HomeViewModel
import com.aya.football_league_application.presentation.util.hide
import com.aya.football_league_application.presentation.util.setGlideImageUrl
import com.aya.football_league_application.presentation.util.show

class DetailsHomeFragment : Fragment() ,onClick{

    private lateinit var binding : FragmentDetailsHomeBinding
    private lateinit var viewModel: HomeViewModel

    private val onClickAdapter : onClick = this
    private val navController by lazy {
        val navHostFragment = activity?.supportFragmentManager
            ?.findFragmentById(R.id.fragment) as NavHostFragment

        navHostFragment.navController
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDetailsHomeBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        getDetailHomeResponse(2000)

        return  binding.root
    }


    private fun getDetailHomeResponse(id:Int){
        progressView(true)

        binding.apply {
            lyNoHaveData.hide()
            viewModel.requestDetailHome(id)
                .observe(viewLifecycleOwner){
                    progressView(false)
                    when(it){
                        is DataCompetitions -> {
                            it.let { data ->
                                model = data
                                adapterSeasons = AdapterSeasons(data.seasons!!, onClickAdapter)
                                imgTeam.setGlideImageUrl(data.emblemUrl!!, progress)
                            } } } }
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

    override fun onClickChoose() {
        navController.navigate(R.id.DetailsHomeFragment_to_TeamsFragment)
    }

}