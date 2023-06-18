package com.example.reminder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskDetailViewModel : ViewModel()  {

    val taskTitleLiveData: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val taskDetailLiveData: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val taskDateLiveData: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val backBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val deleteBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val editBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    //バックボタン
    fun backBntClick() {
        backBtnLiveData.value = true
        deleteBtnLiveData.value = false
        editBtnLiveData.value = false
    }

    //削除ボタン
    fun deleteBntClick() {
        deleteBtnLiveData.value = true
        backBtnLiveData.value = false
        editBtnLiveData.value = false
    }

    //編集ボタン
    fun editBtnClick() {
        editBtnLiveData.value = true
        backBtnLiveData.value = false
        deleteBtnLiveData.value = false
    }
}