package com.example.submissionandroidexpert.di

import com.example.submissionandroidexpert.core.domain.usecase.TeamInteractor
import com.example.submissionandroidexpert.core.domain.usecase.TeamUseCase
import com.example.submissionandroidexpert.detail.DetailViewModel
import com.example.submissionandroidexpert.home.HomeViewModel
import com.example.submissionandroidexpert.home.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<TeamUseCase> {TeamInteractor(get())}
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}