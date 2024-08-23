package com.app.mybaseapp.repository.app_repository

import com.app.mybaseapp.models.user_details.UserDetailsResponse
import com.app.mybaseapp.network.ApiService
import com.app.mybaseapp.utils.NetworkResult
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppRepositoryImplementation @Inject constructor(private val apiService: ApiService) :AppRepository {

    override suspend fun fetchUserDetails(id: Int): NetworkResult<UserDetailsResponse?> {
        return try {
            val response = apiService.fetchUserDetails(id)
            if (response.isSuccessful) {
                NetworkResult.Success(response.body())
            } else {
                NetworkResult.Error(Exception(response.message()))
            }
        } catch (e: Exception) {
            NetworkResult.Error(e)
        }
    }
}