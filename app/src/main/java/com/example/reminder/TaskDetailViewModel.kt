package com.example.reminder

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskDetailViewModel : ViewModel()  {

    val deleteBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }
    val editBtnLiveData: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }

    //削除ボタン
    fun deleteBntClick() {
        deleteBtnLiveData.value = true
    }

    //編集ボタン
    fun editBtnClick() {
        editBtnLiveData.value = true
    }
}