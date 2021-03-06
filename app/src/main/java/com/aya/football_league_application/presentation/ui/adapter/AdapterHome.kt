package com.aya.football_league_application.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.aya.football_league_application.R
import com.aya.football_league_application.data.response.DataCompetitions
import com.aya.football_league_application.databinding.ItemListHomeBinding
import com.aya.football_league_application.presentation.ui.interfaces.onClick

class AdapterHome(
    private var Models: ArrayList<DataCompetitions>,
    private val onclick: onClick
) : RecyclerView.Adapter<AdapterHome.ViewHolderSlider>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSlider {
        val binding: ItemListHomeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_list_home, parent, false
        )
      /*  binding.root.layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )*/
        return ViewHolderSlider(binding)
    }

    override fun getItemCount(): Int {
        return if (Models.size > 0) Models.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolderSlider, position: Int) {
        val model = Models[position]
        holder.bind(model)
        holder.itemRowBinding.layout.setOnClickListener {
            onclick.onClickChoose()
        }
    }

    class ViewHolderSlider(binding: ItemListHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemListHomeBinding = binding
        fun bind(model: DataCompetitions?) {
            itemRowBinding.model = model
            itemRowBinding.executePendingBindings()
        }
    }
}