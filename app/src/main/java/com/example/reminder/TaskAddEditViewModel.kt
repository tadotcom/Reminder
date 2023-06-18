package com.example.reminder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskAddEditViewModel : ViewModel() {

    val backBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val sendBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    //バックボタン
    fun backBntClick() {
        backBtnLiveData.value = true
        sendBtnLiveData.value = false
    }

    //送信ボタン
    fun sendBntClick() {
        sendBtnLiveData.value = true
        backBtnLiveData.value = false
    }
}