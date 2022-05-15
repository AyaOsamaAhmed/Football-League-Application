package com.aya.football_league_application.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.football_league_application.R
import com.aya.football_league_application.data.response.DataTeams
import com.aya.football_league_application.databinding.ItemListTeamBinding

class AdapterTeam(
    private var Models: ArrayList<DataTeams>
) : RecyclerView.Adapter<AdapterTeam.ViewHolderSlider>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSlider {
        val binding: ItemListTeamBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list_team, parent, false
        )
        return ViewHolderSlider(binding)
    }

    override fun getItemCount(): Int {
        return if (Models.size > 0) Models.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolderSlider, position: Int) {
        val model = Models[position]
        holder.bind(model)
       // if(model.crestUrl != null)
      //  holder.itemRowBinding.imgSeason.setGlideImageUrl(model.crestUrl,holder.itemRowBinding.progress)


    }

    class ViewHolderSlider(binding: ItemListTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemListTeamBinding = binding
        fun bind(model: DataTeams?) {
            itemRowBinding.model = model
            itemRowBinding.executePendingBindings()
        }
    }
}