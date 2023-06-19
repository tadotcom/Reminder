package com.example.reminder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.Moshi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

class RecyclerAdapter() : RecyclerView.Adapter<ViewHolderList>() {

    val taskId = listOf("1","2","3","4","5","6")
    val taskTitleList = listOf("タスク1","タスク2","タスク3","タスク4","タスク5","タスク6")
    var taskDetailList = listOf("タスク1詳細","タスク2詳細","タスク3詳細","タスク4詳細","タスク5詳細","タスク6詳細")
    var taskDate = listOf("2023/01/01 01:01:01","2023/02/02 01:01:01","2023/03/03 01:01:01","2023/04/04 01:01:01","2023/05/05 01:01:01","2023/06/06 01:01:01")


    private val repository = TaskRepository()

    init {
        val logging = HttpLoggingInterceptor {
            Timber.tag("OkHttp").d(it)
        }
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val moshi = Moshi.Builder()
            .build()

        val userService = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(TaskService::class.java)

        runBlocking {
            launch {
                val response = userService.getUserInfo()
                if (response.isSuccessful) {
                    val users = response.body()
                    Log.d("KKKKKK1", "MOKIKIU")
                } else {
                    Log.d("KKKKKK2", "MOKIKIU")
                }
            }
        }
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
        return taskTitleList.size
    }
}