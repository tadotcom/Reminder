package com.example.reminder

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewHolderList(itemView: View) : RecyclerView.ViewHolder(itemView){
    val task: TextView =itemView.findViewById(R.id.task)
    private val recyclerAdapter = RecyclerAdapter()
    private val taskTitle  = recyclerAdapter.taskTitleList
    private val taskDetail = recyclerAdapter.taskDetailList

    init {
        itemView.setOnClickListener {
            val position:Int =adapterPosition
            Toast.makeText(itemView.context,"${taskTitle[position]}さんです", Toast.LENGTH_SHORT).show()
        }
    }
}