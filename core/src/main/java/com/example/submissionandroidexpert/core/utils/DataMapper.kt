package com.example.submissionandroidexpert.core.utils

import com.example.submissionandroidexpert.core.data.source.local.entity.TeamEntity
import com.example.submissionandroidexpert.core.data.source.remote.response.TeamsItem
import com.example.submissionandroidexpert.core.domain.model.Team
object DataMapper {
    fun mapResponsesToEntities(input: List<TeamsItem>): List<TeamEntity> {
        val teamList = ArrayList<TeamEntity>()
        input.map {
            val team = TeamEntity(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strBadge = it.strBadge,
                strDescriptionEN = it.strDescriptionEN,
                strStadium = it.strStadium,
                strLocation = it.strLocation,
                isFavorite = false
            )
            teamList.add(team)
        }
        return teamList
    }

    fun mapEntitiesToDomain(input: List<TeamEntity>): List<Team> =
        input.map {
            Team(
                idTeam = it.idTeam,
                strTeam = it.strTeam,
                strBadge = it.strBadge,
                strDescriptionEN = it.strDescriptionEN,
                strStadium = it.strStadium,
                strLocation = it.strLocation,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Team) = TeamEntity(
        idTeam = input.idTeam,
        strTeam = input.strTeam,
        strBadge = input.strBadge,
        strDescriptionEN = input.strDescriptionEN,
        strStadium = input.strStadium,
        strLocation = input.strLocation,
        isFavorite = input.isFavorite
    )
}