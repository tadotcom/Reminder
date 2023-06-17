package com.example.reminder

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.reminder.databinding.FragmentTaskDetailBinding


class TaskDetailFragment : Fragment() {

    private val taskDetailViewModel: TaskDetailViewModel by viewModels()
    private lateinit var binding: FragmentTaskDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        binding.viewModel = taskDetailViewModel

        //バックボタンのオブザーブ
        val backBtnObserver = Observer<Boolean> { backbtn ->
            if(taskDetailViewModel.backBtnLiveData.value == true) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        }

        //削除ボタンのオブザーブ
        val deleteBtnObserver = Observer<Boolean> { deletebtn ->
            if(taskDetailViewModel.deleteBtnLiveData.value == true) {
                DeleteTakDialog()
            }
        }

        //編集ボタンのオブザーブ
        val editBtnObserver = Observer<Boolean> { editbtn ->
            if(taskDetailViewModel.editBtnLiveData.value == true) {
                val intent = Intent(context, TaskAddEditActivity::class.java)
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
                Toast.makeText(context , "タスクを削除しました", Toast.LENGTH_LONG).show()
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
            .create()
            .show()
    }
}