package com.example.reminder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import kotlin.concurrent.thread

class RecyclerAdapter() : RecyclerView.Adapter<ViewHolderList>() {

    val taskId = listOf("1","2","3","4","5","6")
    var taskTitleList = mutableListOf("タスク1","タスク2","タスク3","タスク4","タスク5","タスク6")
    var taskDetailList = listOf("タスク1詳細","タスク2詳細","タスク3詳細","タスク4詳細","タスク5詳細","タスク6詳細")
    var taskDate = listOf("2023/01/01 01:01:01","2023/02/02 01:01:01","2023/03/03 01:01:01","2023/04/04 01:01:01","2023/05/05 01:01:01","2023/06/06 01:01:01")

   var aaaa:List<String> = listOf("")

    init {

//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.github.com")
//            .build()
//
//        val service = retrofit.create(TaskService::class.java)
//        //val loadRepos = service.loadRepos("octocat", "created")
//
//        CoroutineScope(Dispatchers.IO).launch {
//            val response = service.aaaaaaaaa("octocat", "created")
//            if (response.isSuccessful) {
//                val users = response.body()
//            }
//        }

//        thread {
//            runCatching { loadRepos.clone().execute() }
//                .onSuccess { response ->
//                    if (response.isSuccessful) {
//                        response.body()?.string()?.let { json ->
//                            Log.d("AAAAA1", json)
//                            Log.d("AAAAA2", json.substring(7,16))
//                            taskTitleList.add("aaaa")
//                        }
//                    } else {
//                        val msg = "HTTP error. HTTP status code: ${response.code()}"
//                        Log.e("AAAAA3", msg)
//                    }
//                }
//                .onFailure { t -> Log.e("AAAAA4", t.toString()) }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {



        val itemXml = LayoutInflater.from(parent.context).inflate(R.layout.task_list,parent,false)
        return ViewHolderList(itemXml)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        holder.task.text = taskTitleList[position]
        //holder.task.text = taskDetailList[position]
    }

    override fun getItemCount(): Int {

//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.github.com")
//            .build()
//
//        val service = retrofit.create(TaskService::class.java)
//        val loadRepos = service.loadRepos("octocat", "created")
//
//        thread {
//            runCatching { loadRepos.clone().execute() }
//                .onSuccess { response ->
//                    if (response.isSuccessful) {
//                        response.body()?.string()?.let { json ->
//                            Log.d("AAAAA1", json)
//                            Log.d("AAAAA2", json.substring(7,16))
//                            taskTitleList.add("aaaa")
//                        }
//                    } else {
//                        val msg = "HTTP error. HTTP status code: ${response.code()}"
//                        Log.e("AAAAA3", msg)
//                    }
//                }
//                .onFailure { t -> Log.e("AAAAA4", t.toString()) }
//        }

        return taskTitleList.size
    }
}