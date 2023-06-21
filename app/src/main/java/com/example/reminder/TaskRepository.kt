//
//package com.example.reminder
//
//
//
//class TaskRepository {
//
//    private val apiService = RetrofitClient.apiService
//
//    suspend fun getItems(): List<User> {
//        return apiService.getItems()
//    }
////    private var service: TaskService = Retrofit.Builder()
////        .baseUrl("https://qiita.com/api/v2/")
////        .addConverterFactory(MoshiConverterFactory.create())
////        .build()
////        .create(TaskService::class.java)
////
////    fun getArticles(query: String?): List<Article>? {
////        try {
////            val response = service.getArticles(query).execute()
////            // リクエストが成功した場合
////            if (response.isSuccessful) {
////                return response.body()
////            } else {
////                Log.d("QiitaRepository", "GET ERROR")
////            }
////        } catch (e: IOException) {
////            e.printStackTrace()
////        }
////        return null
////    }
//}
