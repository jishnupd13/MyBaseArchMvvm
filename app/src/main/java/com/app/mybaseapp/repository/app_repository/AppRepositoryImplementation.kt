package com.app.mybaseapp.repository.app_repository

import android.content.SharedPreferences
import android.util.Log
import com.app.mybaseapp.models.user_details.UserDetailsResponse
import com.app.mybaseapp.network.ApiService
import com.app.mybaseapp.utils.NetworkResult
import com.app.mybaseapp.utils.PreferenceHelper
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppRepositoryImplementation @Inject constructor(
    private val apiService: ApiService,
    private val preferenceHelper: PreferenceHelper
) :AppRepository {

    override suspend fun fetchUserDetails(id: Int): NetworkResult<UserDetailsResponse?> {
        return try {
            val response = apiService.fetchUserDetails(id)
            if (response.isSuccessful) {
                preferenceHelper.saveInt("key",99)
                NetworkResult.Success(response.body())
            } else {
                NetworkResult.Error(Exception(response.message()))
            }
        } catch (e: Exception) {
            preferenceHelper.saveInt("key",-1)
            NetworkResult.Error(e)
        }
    }
}