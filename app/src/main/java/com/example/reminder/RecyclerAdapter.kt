package com.example.reminder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter() : RecyclerView.Adapter<ViewHolderList>() {

    val taskTitleList = listOf("タスク1","タスク2","タスク3","タスク4","タスク5","タスク6")
    val taskDetailList = listOf("タスク1詳細","タスク2詳細","タスク3詳細","タスク4詳細","タスク5詳細","タスク6詳細")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
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