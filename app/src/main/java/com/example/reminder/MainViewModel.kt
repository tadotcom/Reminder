package com.example.reminder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Time
import java.util.Calendar

class MainViewModel : ViewModel() {

    //private val repository = TaskRepository()
    val taskTitle: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val taskDetail: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val taskCalender: MutableLiveData<Calendar> by lazy { MutableLiveData<Calendar>() }
    val taskTime: MutableLiveData<Time> by lazy { MutableLiveData<Time>() }
    val taskImportance: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val addTaskBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }


    init {

//        val logging = HttpLoggingInterceptor {
//            Timber.tag("OkHttp").d(it)
//        }
//        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
//
//        val client = OkHttpClient.Builder()
//            .addInterceptor(logging)
//            .build()
//
//        val moshi = Moshi.Builder()
//            //.add(KotlinJsonAdapterFactory())
//            .build()
//
//        val userService = Retrofit.Builder()
//            .baseUrl("https://api.github.com")
//            .client(client)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .build()
//            .create(TaskService::class.java)
//
//        GlobalScope.launch {
//            val response = userService.loadRepos("octocat", "created")
//            var a = response.clone().execute()
//            if (a.isSuccessful) {
//
//
//            } else {
//
//            }
//        }
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.github.com")
//            .build()
//
//        val service = retrofit.create(TaskService::class.java)
//
//
//        val loadRepos = service.loadRepos("octocat", "created")
//
//        thread {
//            runCatching { loadRepos.clone().execute() }
//                .onSuccess { response ->
//                    if (response.isSuccessful) {
//                        response.body()?.string()?.let { json ->
//                            Log.d(TAG, json)
//                            Log.d("CCCC1", json)
//                            a.value = listOf("AAAAA")
//                        }
//                    } else {
//                        val msg = "HTTP error. HTTP status code: ${response.code()}"
//                        Log.e(TAG, msg)
//                        Log.d("CCCC2", msg)
//                    }
//                }
//                .onFailure { t -> Log.e(TAG, t.toString()) }
//        }
    }

    //タスク追加ボタンクリック
    fun addTaskBntClick() {
        addTaskBtnLiveData.value = true
    }
}