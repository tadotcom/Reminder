package com.example.reminder

import com.squareup.moshi.Json
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface TaskService {
    @POST("users/tadotcom/repos")
    suspend fun getUserInfo(
        @Path("user_name") userName: String,
        @Query("query") query: String
    ): Response<String>

    //紐づけ用メソッド
    @POST("beaconvi.local/Api/Link")
    suspend fun linkData(@Body getData: LinkData): Response<LinkResponseData>

    //紐づけ解除用メソッド
    @POST("beaconvi.local/Api/Unlink")
    suspend fun unlinkData(@Body getData: UnLinkData): Response<UnLinkResponseData>

    @GET("users/{username}/repos")
    fun aaaaaaaaa(
        @Path("username") username: String, @Query("sort") sort: String
    ): Call<ResponseBody>

    @GET//("users/{username}/repos")
    fun loadRepos(
        @Path("username") username: String, @Query("sort") sort: String
    ): Call<ResponseBody>
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

//紐づけ用のデータクラス(リクエスト用)
data class LinkData(
    @Json(name = "ItemCode")
    var ItemCode: String,
    @Json(name = "TagNumber")
    var TagNumber: Int,
    @Json(name = "Value01")
    var Value01: Int
)

//紐づけ用のデータクラス(レスポンス用)
data class LinkResponseData(
    @Json(name = "ExecuteCount")
    var ExecuteCount: Int,
    @Json(name = "ResultCode")
    var ResultCode: Int,
    @Json(name = "ResultMessage")
    var ResultMessage: String
)

//紐づけ解除用のデータクラス(リクエスト用)
//null許容の場合以下にする？
//var ItemCode: String = "",
//var TagNumber: Int = null
data class UnLinkData(
    @Json(name = "ItemCode")
    var ItemCode: String,
    @Json(name = "TagNumber")
    var TagNumber: Int
)

//紐づけ解除用のデータクラス(レスポンス用)
data class UnLinkResponseData(
    @Json(name = "ResultCode")
    var ResultCode: Int,
    @Json(name = "ResultMessage")
    var ResultMessage: String,
    @Json(name = "ExecuteCount")
    var ExecuteCount: Int
)