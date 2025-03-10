package com.example.submissionandroidexpert.core.domain.usecase

import com.example.submissionandroidexpert.core.data.Resource
import com.example.submissionandroidexpert.core.domain.model.Team
import kotlinx.coroutines.flow.Flow

interface TeamUseCase {

    fun getAllTeam(): Flow<Resource<List<Team>>>

    fun getFavoriteTeam(): Flow<List<Team>>

    fun setFavoriteTeam(team: Team, state: Boolean)

    fun searchTeamByName(query: String): Flow<List<Team>>
}