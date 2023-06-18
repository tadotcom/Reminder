package com.example.reminder

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.reminder.databinding.FragmentTaskDetailBinding


class TaskDetailFragment : Fragment() {

    private val taskDetailViewModel: TaskDetailViewModel by viewModels()
    private lateinit var binding: FragmentTaskDetailBinding

    lateinit var taskid: String
    lateinit var taskTitle: String
    lateinit var taskDetail: String
    lateinit var taskDate: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        taskid = activity?.intent?.getStringExtra("taskId").toString()
        taskTitle = activity?.intent?.getStringExtra("taskTitle").toString()
        taskDetail = activity?.intent?.getStringExtra("taskDetail").toString()
        taskDate = activity?.intent?.getStringExtra("taskDate").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        binding.viewModel = taskDetailViewModel

        //タスクタイトル
        if (taskTitle.isNotBlank()) {
            binding.title.text = taskTitle
        } else {
            binding.title.text = "タスクタイトルなし"
        }

        //タスク詳細
        if (taskDetail.isNotBlank()) {
            binding.detail.text = taskDetail
        } else {
            binding.detail.text = "タスク詳細なし"
        }

        //タスク日時
        if (taskDate.isNotBlank()) {
            binding.taskDate.text = taskDate
        } else {
            binding.taskDate.text = "日時指定なし"
        }

        //バックボタンのオブザーブ
        val backBtnObserver = Observer<Boolean> { backbtn ->
            if (taskDetailViewModel.backBtnLiveData.value == true) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        }

        //削除ボタンのオブザーブ
        val deleteBtnObserver = Observer<Boolean> { deletebtn ->
            if (taskDetailViewModel.deleteBtnLiveData.value == true) {
                DeleteTakDialog()
            }
        }

        //編集ボタンのオブザーブ
        val editBtnObserver = Observer<Boolean> { editbtn ->
            if (taskDetailViewModel.editBtnLiveData.value == true) {
                val intent = Intent(context, TaskAddEditActivity::class.java)
                intent.putExtra("taskId", taskid)
                intent.putExtra("taskTitle", taskTitle)
                intent.putExtra("taskDetail", taskDetail)
                intent.putExtra("taskDetail", taskDate)
                startActivity(intent)
            }
        }

        taskDetailViewModel.deleteBtnLiveData.observe(viewLifecycleOwner, backBtnObserver)
        taskDetailViewModel.deleteBtnLiveData.observe(viewLifecycleOwner, deleteBtnObserver)
        taskDetailViewModel.editBtnLiveData.observe(viewLifecycleOwner, editBtnObserver)

        return binding.root
    }

    fun DeleteTakDialog() {
        AlertDialog.Builder(context)
            .setTitle("このタスクを削除しますか？")
            .setMessage("タスクのタイトル")
            .setPositiveButton("削除") { dialog, which ->
                Toast.makeText(context, "タスクを削除しました", Toast.LENGTH_LONG).show()
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
            .create()
            .show()
    }
}