package com.example.reminder

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class TaskRepository {

    private var database = FirebaseFirestore.getInstance()
    private var a: String = "何もない"

    //データを取得する
    fun fetchTask():String {
        val docRef = database.collection("reminder").document("taskListData")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                    a = document.data.toString()
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
        return a
    }

    fun addTask(taskTitle: String, taskDetail: String) {
        val task = hashMapOf("TITLE" to taskTitle, "DETAIL" to taskDetail)
        database.collection("reminder").document("taskListData")
            .set(task)
            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

        val docRef = database.collection("taskList").document("task")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d(TAG, "DocumentSnapshot data: ${document.data}")
                } else {
                    Log.d(TAG, "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }
    }
}