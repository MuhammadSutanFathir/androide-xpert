package com.example.submissionandroidexpert.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.submissionandroidexpert.R
import com.example.submissionandroidexpert.core.domain.model.Team
import com.example.submissionandroidexpert.databinding.ActivityDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val detailTeam = getParcelableExtra(intent, EXTRA_DATA, Team::class.java)
        showDetailTeam(detailTeam)

        binding.back.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        window.statusBarColor = ContextCompat.getColor(this, R.color.cherry_rush)

    }

    private fun showDetailTeam(detailTeam: Team?) {
        detailTeam?.let {
            binding.tvName.text = detailTeam.strTeam
            Glide.with(this@DetailActivity)
                .load(detailTeam.strBadge)
                .into(binding.imageTeam)

            var statusFavorite = detailTeam.isFavorite
            binding.tvLocation.text = detailTeam.strLocation
            binding.tvStadium.text = detailTeam.strStadium
            binding.tvDesciption.text = detailTeam.strDescriptionEN
            setStatusFavorite(statusFavorite)
            binding.favorite.setOnClickListener {
                statusFavorite = !statusFavorite
                detailViewModel.setFavoriteTeam(detailTeam, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.favorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24))
        } else {
            binding.favorite.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.baseline_favorite_border_24))
        }
    }
    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}