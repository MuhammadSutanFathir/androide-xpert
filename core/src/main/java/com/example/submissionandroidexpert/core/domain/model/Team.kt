package com.example.submissionandroidexpert.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team (
    val idTeam : String,
    val strTeam : String,
    val strBadge: String,
    val strDescriptionEN: String,
    val strStadium: String,
    val strLocation: String,
    var isFavorite: Boolean
): Parcelable