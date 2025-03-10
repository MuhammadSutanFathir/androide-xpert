package com.example.submissionandroidexpert.core.data.source.remote.network

import com.example.submissionandroidexpert.core.data.source.remote.response.TeamResponse
import retrofit2.http.GET

interface ApiService {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    suspend fun getList(): TeamResponse
}