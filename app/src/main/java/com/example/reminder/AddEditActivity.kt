package com.example.reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddEditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = AddEditFragment()
        fragmentTransaction.add(R.id.addedit_fragment, fragment)
        fragmentTransaction.commit()
    }
}