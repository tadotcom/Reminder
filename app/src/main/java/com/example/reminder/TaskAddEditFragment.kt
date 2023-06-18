package com.example.reminder

import android.app.DatePickerDialog
import android.app.TimePickerDialog
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

        //日付指定
        binding.calnder.setOnClickListener {
            val dtp = context?.let { it1 ->
                DatePickerDialog(
                    it1, { view, y, m, d ->
                        //Toast.makeText(context, "日付を設定！" + y + m + d, Toast.LENGTH_LONG).show()
                        binding.taskDate.text = y.toString() + "年" + (m + 1).toString() + "月" + d.toString() + "日"
                    }, 2020, 12, 1
                )
            }
            if (dtp != null) {
                dtp.show()
            }
        }

        //日時指定
        binding.clock.setOnClickListener {
            val dtp = TimePickerDialog(
                context, { view, h, m ->
                    //Toast.makeText(context, "日付を設定！" + h + m, Toast.LENGTH_LONG).show()
                    binding.taskTime.text = h.toString() + "時" + m.toString() + "分"
                }, 24, 60, true
            )
            dtp.show()
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