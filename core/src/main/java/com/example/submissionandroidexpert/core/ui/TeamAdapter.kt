package com.example.submissionandroidexpert.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionandroidexpert.core.databinding.ItemTeamBinding
import com.example.submissionandroidexpert.core.domain.model.Team

class TeamAdapter : ListAdapter<Team, TeamAdapter.ListViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((Team) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            ItemTeamBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Team) {
            Glide.with(itemView.context)
                .load(data.strBadge)
                .into(binding.image)
            binding.name.text = data.strTeam
            binding.location.text = data.strLocation
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Team> =
            object : DiffUtil.ItemCallback<Team>() {
                override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
                    return oldItem.idTeam == newItem.idTeam
                }

                override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
                    return oldItem == newItem
                }
            }
    }
}