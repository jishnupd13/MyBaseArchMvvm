package com.app.mybaseapp.repository.app_repository

import com.app.mybaseapp.models.user_details.UserDetailsResponse
import com.app.mybaseapp.utils.NetworkResult
import dagger.Binds
import retrofit2.Response

interface AppRepository {
    suspend fun fetchUserDetails(id:Int):NetworkResult<UserDetailsResponse?>
}