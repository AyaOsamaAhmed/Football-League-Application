package com.aya.football_league_application.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.football_league_application.R
import com.aya.football_league_application.data.response.DataCompetitions
import com.aya.football_league_application.databinding.ItemListHomeBinding

class AdapterHome(
    private var Models: ArrayList<DataCompetitions>
) : RecyclerView.Adapter<AdapterHome.ViewHolderSlider>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSlider {
        val binding: ItemListHomeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list_home, parent, false
        )
        binding.root.layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return ViewHolderSlider(binding)
    }

    override fun getItemCount(): Int {
        return if (Models.size > 0) Models.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolderSlider, position: Int) {
        val model = Models[position]
        holder.bind(model)
        holder.itemRowBinding.layout.setOnClickListener {

        }
    }

    class ViewHolderSlider(binding: ItemListHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemListHomeBinding = binding
        fun bind(obj: Any?) {
           // itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }
    }
}