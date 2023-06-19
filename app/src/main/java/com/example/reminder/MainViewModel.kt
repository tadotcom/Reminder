package com.example.reminder

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Retrofit
import java.sql.Time
import java.util.Calendar
import kotlin.concurrent.thread

class MainViewModel : ViewModel() {

    //private val repository = TaskRepository()
    val taskTitle: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val taskDetail: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val taskCalender: MutableLiveData<Calendar> by lazy { MutableLiveData<Calendar>() }
    val taskTime: MutableLiveData<Time> by lazy { MutableLiveData<Time>() }
    val taskImportance: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val addTaskBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    var list = listOf("AAA", "BBB", "CCC")

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://aaaa")
            .build()

        val service = retrofit.create(TaskService::class.java)


        val loadRepos = service.loadRepos("octocat", "created")
        thread {
            runCatching { loadRepos.clone().execute() }
                .onSuccess { response ->
                    if (response.isSuccessful) {
                        response.body()?.string()?.let { json ->
                            Log.d("CCCC1", json)
                            list = listOf("AAAA")
                        }
                    } else {
                        val msg = "HTTP error. HTTP status code: ${response.code()}"
                        Log.e("CCCC2", msg)
                    }
                }
                .onFailure { t -> Log.e("CCCC3", t.toString()) }
        }
    }

    //タスク追加ボタンクリック
    fun addTaskBntClick() {
        addTaskBtnLiveData.value = true
    }
}