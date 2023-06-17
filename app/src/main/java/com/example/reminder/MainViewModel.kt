package com.example.reminder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Time
import java.util.Calendar

class MainViewModel : ViewModel() {

    private val repository = TaskRepository()
    val taskTitle: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val taskDetail: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val taskCalender: MutableLiveData<Calendar> by lazy { MutableLiveData<Calendar>() }
    val taskTime: MutableLiveData<Time> by lazy { MutableLiveData<Time>() }
    val taskImportance: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val addTaskBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    //タスク追加ボタンクリック
    fun addTaskBntClick() {
        addTaskBtnLiveData.value = true
    }
}