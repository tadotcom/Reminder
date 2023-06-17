package com.example.reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TaskDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = TaskDetailFragment()
        fragmentTransaction.add(R.id.taskDetailfragment, fragment)
        fragmentTransaction.commit()
    }
}