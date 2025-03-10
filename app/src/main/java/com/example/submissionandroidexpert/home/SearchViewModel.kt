package com.example.submissionandroidexpert.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.submissionandroidexpert.core.domain.usecase.TeamUseCase

class SearchViewModel(private val teamUseCase: TeamUseCase) : ViewModel() {
    fun searchTeam(query: String)= teamUseCase.searchTeamByName(query).asLiveData()
}