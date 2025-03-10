package com.example.submissionandroidexpert.core.data.source.remote

import com.example.submissionandroidexpert.core.data.source.remote.network.ApiResponse
import com.example.submissionandroidexpert.core.data.source.remote.network.ApiService
import com.example.submissionandroidexpert.core.data.source.remote.response.TeamsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {


    fun getAllTeam(): Flow<ApiResponse<List<TeamsItem>>> {
        return flow {
            try {
                val response = apiService.getList()
                val dataArray = response.teams
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.teams))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}