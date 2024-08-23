package com.app.mybaseapp.network

import com.app.mybaseapp.models.user_details.UserDetailsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{id}")
    suspend fun fetchUserDetails(
        @Path("id") id: Int
    ) : Response<UserDetailsResponse>
}