package com.example.reminder

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TaskService {
    @GET("users/tadotcom/repos")
    suspend fun getUserInfo(
        @Path("id") userName: String,
        @Query("name") query: String
    ): Response<UserResponse>
}

data class UserResponse(
    val users: List<User>
)

data class User(
    val id: Int,
    val detail: String
)