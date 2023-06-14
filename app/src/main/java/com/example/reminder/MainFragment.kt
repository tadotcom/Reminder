package com.example.reminder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reminder.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private var binding: FragmentMainBinding? = null

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

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}