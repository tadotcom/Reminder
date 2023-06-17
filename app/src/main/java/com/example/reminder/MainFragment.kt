package com.example.reminder

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reminder.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        val view = binding!!.root

        //リサイクルビューを表示
        val linearLayoutManager = LinearLayoutManager(view.context)
        val adapter = RecyclerAdapter()
        binding!!.taskList.layoutManager = LinearLayoutManager(view.context)
        binding!!.taskList.layoutManager = linearLayoutManager
        binding!!.taskList.adapter = adapter

        binding.viewmodel = mainViewModel

        //タスクの追加ボタンのオブザーブ
        val addTaskBtnObserver = Observer<Boolean> { addTaskbtn ->
            if(mainViewModel.addTaskBtnLiveData.value == true) {
                val intent = Intent(context, TaskAddEditActivity::class.java)
                startActivity(intent)
            }
        }

        //オブザーブの登録
        mainViewModel.addTaskBtnLiveData.observe(viewLifecycleOwner, addTaskBtnObserver)

        return binding.root
    }

//    companion object {
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            MainFragment().apply {
//                arguments = Bundle().apply {
//                }
//            }
//    }
}