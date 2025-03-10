package com.example.submissionandroidexpert.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.submissionandroidexpert.core.domain.model.Team
import com.example.submissionandroidexpert.core.domain.usecase.TeamUseCase

class HomeViewModel(teamUseCase: TeamUseCase) : ViewModel() {

    val team = teamUseCase.getAllTeam().asLiveData()


}