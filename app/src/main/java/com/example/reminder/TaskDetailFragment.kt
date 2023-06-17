package com.example.reminder

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.reminder.databinding.FragmentMainBinding
import com.example.reminder.databinding.FragmentTaskDetailBinding


class TaskDetailFragment : Fragment() {

    private val taskDetailViewModel: TaskDetailViewModel by viewModels()
    private lateinit var binding: FragmentTaskDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        taskDetailViewModel.deleteBtnLiveData.observe(this, Observer { isEnabled ->
//            //binding.button.isEnabled = isEnabled
//            binding.deleteBnt.isEnabled = isEnabled
//        })
//
//        val eeeObserver = Observer<Boolean> { aaa ->
//            if(taskDetailViewModel.deleteBtnLiveData.value == true) {
//                Toast.makeText(context , "削除ボタン", Toast.LENGTH_LONG).show();
//                Log.d("AAAAAAAAAAA", "削除ボタン")
//            }
//        }
//
//        val cccObserver = Observer<Boolean> { aaa ->
//            if(taskDetailViewModel.editBtnLiveData.value == true) {
//                Toast.makeText(context , "編集ボタン", Toast.LENGTH_LONG).show();
//                Log.d("AAAAAAAAAAA", "編集ボタン")
//            }
//        }
//
//        taskDetailViewModel.deleteBtnLiveData.observe(this, eeeObserver)
//        taskDetailViewModel.editBtnLiveData.observe(this, cccObserver)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding.viewModel = taskDetailViewModel
        binding.lifecycleOwner = this

        val eeeObserver = Observer<Boolean> { aaa ->
            if(taskDetailViewModel.deleteBtnLiveData.value == true) {
                Toast.makeText(context , "削除ボタン", Toast.LENGTH_LONG).show();
                Log.d("AAAAAAAAAAA", "削除ボタン")
            }
        }

        val cccObserver = Observer<Boolean> { aaa ->
            if(taskDetailViewModel.editBtnLiveData.value == true) {
                Toast.makeText(context , "編集ボタン", Toast.LENGTH_LONG).show();
                Log.d("AAAAAAAAAAA", "編集ボタン")
            }
        }

        taskDetailViewModel.deleteBtnLiveData.observe(viewLifecycleOwner, eeeObserver)
        taskDetailViewModel.editBtnLiveData.observe(viewLifecycleOwner, cccObserver)

        return inflater.inflate(R.layout.fragment_task_detail, container, false)
    }
}