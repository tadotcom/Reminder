package com.example.reminder

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.reminder.databinding.FragmentMainBinding
import com.example.reminder.databinding.FragmentTaskAddEditBinding
import com.example.reminder.databinding.FragmentTaskDetailBinding

class TaskAddEditFragment : Fragment() {

    private val taskAddEditViewModel: TaskAddEditViewModel by viewModels()
    private lateinit var binding: FragmentTaskAddEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskAddEditBinding.inflate(inflater, container, false)
        binding.viewModel = taskAddEditViewModel

        //バックボタンのオブザーブ
        val backBtnObserver = Observer<Boolean> { backbtn ->
            if(taskAddEditViewModel.backBtnLiveData.value == true) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
            }
        }

        //登録ボタンのオブザーブ
        val deleteBtnObserver = Observer<Boolean> { deletebtn ->
            if(taskAddEditViewModel.sendBtnLiveData.value == true) {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(context , "タスクの登録が完了しました", Toast.LENGTH_LONG).show()
            }
        }

        taskAddEditViewModel.backBtnLiveData.observe(viewLifecycleOwner, backBtnObserver)
        taskAddEditViewModel.sendBtnLiveData.observe(viewLifecycleOwner, deleteBtnObserver)

        return binding.root
    }
}