package com.aya.football_league_application.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.football_league_application.R
import com.aya.football_league_application.data.response.SeasonsResponse
import com.aya.football_league_application.databinding.ItemSeasonBinding
import com.aya.football_league_application.presentation.ui.interfaces.onClick
import com.aya.football_league_application.presentation.util.setGlideImageUrl

class AdapterSeasons(
    private var Models: ArrayList<SeasonsResponse>,
    private val onclick: onClick
) : RecyclerView.Adapter<AdapterSeasons.ViewHolderSlider>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSlider {
        val binding: ItemSeasonBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_season, parent, false
        )
        return ViewHolderSlider(binding)
    }

    override fun getItemCount(): Int {
        return if (Models.size > 0) Models.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolderSlider, position: Int) {
        val model = Models[position]
        holder.bind(model)
        if(model.winner != null)
        holder.itemRowBinding.imgSeason.setGlideImageUrl(model.winner.crestUrl,holder.itemRowBinding.progress)

        holder.itemRowBinding.layout.setOnClickListener {
            onclick.onClickChoose()
        }
    }

    class ViewHolderSlider(binding: ItemSeasonBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemSeasonBinding = binding
        fun bind(model: SeasonsResponse?) {
            itemRowBinding.model = model
            itemRowBinding.executePendingBindings()
        }
    }
}