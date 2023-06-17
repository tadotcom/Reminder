package com.example.reminder

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ViewHolderList(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val task: TextView =itemView.findViewById(R.id.task)
    private val recyclerAdapter = RecyclerAdapter()
    private val taskTitle  = recyclerAdapter.taskTitleList
    private val taskDetail = recyclerAdapter.taskDetailList

    init {
        itemView.setOnClickListener {
            val position:Int =adapterPosition

            val intent: Intent = Intent(itemView.context ,TaskDetailActivity().javaClass)
            intent.putExtra("taskTitle", taskTitle[position])
            intent.putExtra("taskDetail", taskDetail[position])
            itemView.getContext().startActivity(intent);
        }
    }
}