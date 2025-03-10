package com.example.submissionandroidexpert.core.domain.usecase

import androidx.lifecycle.LiveData
import com.example.submissionandroidexpert.core.domain.model.Team
import com.example.submissionandroidexpert.core.domain.repository.ITeamRepository

class TeamInteractor(private val teamRepository: ITeamRepository) : TeamUseCase {
    override fun getAllTeam() = teamRepository.getAllTeam()

    override fun getFavoriteTeam() = teamRepository.getFavoriteTeam()

    override fun setFavoriteTeam(team: Team, state: Boolean) =
        teamRepository.setFavoriteTeam(team, state)

    override fun searchTeamByName(query: String) = teamRepository.searchTeamByName(query)

}