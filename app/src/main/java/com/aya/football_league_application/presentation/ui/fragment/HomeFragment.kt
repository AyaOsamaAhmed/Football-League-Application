package com.aya.football_league_application.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aya.football_league_application.data.response.HomeResponse
import com.aya.football_league_application.databinding.FragmentHomeBinding
import com.aya.football_league_application.presentation.ui.activity.MainActivity
import com.aya.football_league_application.presentation.ui.adapter.AdapterHome
import com.aya.football_league_application.presentation.ui.viewModel.HomeViewModel
import com.aya.football_league_application.presentation.util.hide
import com.aya.football_league_application.presentation.util.show

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater , container , false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        getHomeResponse()

        return  binding.root
    }


    private fun getHomeResponse(){
        progressView(true)

        binding.apply {
            lyNoHaveData.hide()
            viewModel.responseHome()
                .observe(viewLifecycleOwner){
                    progressView(false)
                    when(it){
                        is HomeResponse -> {
                                it.data.let { data ->
                                    if (data != null){
                                        // Sponsors
                                        if (!data.isNullOrEmpty()){
                                            lyAdapterHOme.show()
                                            adapterHome = AdapterHome(data)
                                        }else{
                                            lyAdapterHOme.hide()
                                        }
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