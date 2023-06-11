package com.example.reminder

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore




class TaskRepository {

    private var database = FirebaseFirestore.getInstance()

    //データを取得する
    fun fetchTask() {
        val docRef = database.collection("cities").document("SF")
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