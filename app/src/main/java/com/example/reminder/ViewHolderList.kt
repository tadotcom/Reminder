package com.example.reminder

import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewHolderList(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val task: TextView =itemView.findViewById(R.id.task)
    private val recyclerAdapter = RecyclerAdapter()

    private val taskid  = recyclerAdapter.taskId
    private val taskTitle  = recyclerAdapter.taskTitleList
    private val taskDetail = recyclerAdapter.taskDetailList
    private val taskDate = recyclerAdapter.taskDate

    init {
        itemView.setOnClickListener {
            val position:Int =adapterPosition

            Log.d("CCCC5", "")

            val intent: Intent = Intent(itemView.context ,TaskDetailActivity().javaClass)
            intent.putExtra("taskId", taskid[position])
            intent.putExtra("taskTitle", taskTitle[position])
            intent.putExtra("taskDetail", taskDetail[position])
            intent.putExtra("taskDate", taskDate[position])
            itemView.getContext().startActivity(intent);
        }
    }
}