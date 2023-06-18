package com.example.reminder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter() : RecyclerView.Adapter<ViewHolderList>() {

    val taskId = listOf("1","2","3","4","5","6")
    val taskTitleList = listOf("タスク1","タスク2","タスク3","タスク4","タスク5","タスク6")
    var taskDetailList = listOf("タスク1詳細","タスク2詳細","タスク3詳細","タスク4詳細","タスク5詳細","タスク6詳細")
    var taskDate = listOf("タスク1詳細","タスク2詳細","タスク3詳細","タスク4詳細","タスク5詳細","タスク6詳細")

    private val repository = TaskRepository()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        //データを取得する
        //Log.d("AAAAAAAA", repository.fetchTask())

        val itemXml = LayoutInflater.from(parent.context).inflate(R.layout.task_list,parent,false)
        return ViewHolderList(itemXml)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        holder.task.text = taskTitleList[position]
        holder.task.text = taskDetailList[position]
    }

    override fun getItemCount(): Int {
        return taskTitleList.size
    }
}