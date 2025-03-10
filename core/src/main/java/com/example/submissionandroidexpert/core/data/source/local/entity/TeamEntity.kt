package com.example.submissionandroidexpert.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
data class TeamEntity (
    @PrimaryKey
    @ColumnInfo(name = "idTeam")
    val idTeam : String,

    @ColumnInfo(name= "strTeam")
    val strTeam : String,

    @ColumnInfo(name = "strBadge")
    val strBadge: String,

    @ColumnInfo(name = "strDescriptionEN")
    val strDescriptionEN: String,

    @ColumnInfo(name = "strStadium")
    val strStadium: String,

    @ColumnInfo(name = "strLocation")
    val strLocation: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)