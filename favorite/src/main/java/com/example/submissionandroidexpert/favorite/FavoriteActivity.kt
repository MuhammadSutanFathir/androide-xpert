package com.example.submissionandroidexpert.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.submissionandroidexpert.R
import com.example.submissionandroidexpert.core.ui.TeamAdapter
import com.example.submissionandroidexpert.detail.DetailActivity
import com.example.submissionandroidexpert.favorite.databinding.ActivityFavoriteBinding
import com.example.submissionandroidexpert.favorite.di.favoriteModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private val favoriteViewModel: FavoriteViewModel by viewModel()
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.statusBarColor = ContextCompat.getColor(this, R.color.cherry_rush)

        loadKoinModules(favoriteModule)

        val teamAdapter = TeamAdapter()
        teamAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        favoriteViewModel.favoriteTeam.observe(this) { dataTeam ->
            teamAdapter.submitList(dataTeam)
            binding.viewEmpty.root.visibility =
                if (dataTeam.isNotEmpty()) View.GONE else View.VISIBLE
        }

        with(binding.rvTeam) {
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            setHasFixedSize(true)
            adapter = teamAdapter
        }
    }

}