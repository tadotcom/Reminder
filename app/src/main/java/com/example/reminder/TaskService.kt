package com.example.reminder

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TaskService {
    @POST("users/tadotcom/repos")
    suspend fun getUserInfo(
        //@Path("user_name") userName: String,
        //@Query("query") query: String
    ): Response<String>
}

data class UserResponse(
    // 変数名とJSONのキー名を一致させている
    val users: List<User>
)

data class User(
    // 変数名とJSONのキー名を一致させている
    val id: String,
    val node_id: String
)