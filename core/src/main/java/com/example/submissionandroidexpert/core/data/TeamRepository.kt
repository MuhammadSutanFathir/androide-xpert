package com.example.submissionandroidexpert.core.data

import com.example.submissionandroidexpert.core.data.source.local.LocalDataSource
import com.example.submissionandroidexpert.core.data.source.remote.RemoteDataSource
import com.example.submissionandroidexpert.core.data.source.remote.network.ApiResponse
import com.example.submissionandroidexpert.core.data.source.remote.response.TeamsItem
import com.example.submissionandroidexpert.core.domain.model.Team
import com.example.submissionandroidexpert.core.domain.repository.ITeamRepository
import com.example.submissionandroidexpert.core.utils.AppExecutors
import com.example.submissionandroidexpert.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TeamRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : ITeamRepository {

    override fun getAllTeam(): Flow<Resource<List<Team>>> =
        object : NetworkBoundResource<List<Team>, List<TeamsItem>>(appExecutors) {
            override fun loadFromDB(): Flow<List<Team>> {
                return localDataSource.getAllTeam().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Team>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<TeamsItem>>> =
                remoteDataSource.getAllTeam()

            override suspend fun saveCallResult(data: List<TeamsItem>) {
                val teamList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertTeam(teamList)
            }
        }.asFlow()

    override fun getFavoriteTeam(): Flow<List<Team>> {
        return localDataSource.getFavoriteTeam().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteTeam(team: Team, state: Boolean) {
        val teamEntity = DataMapper.mapDomainToEntity(team)
        appExecutors.diskIO().execute { localDataSource.setFavoriteTeam(teamEntity, state) }
    }

    override fun searchTeamByName(query: String): Flow<List<Team>> {
        return localDataSource.searchTeamByName(query).map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }
}