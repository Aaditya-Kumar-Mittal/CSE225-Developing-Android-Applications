package com.example.cse225_codes

import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ClassTaskOneToolbar1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_task_one_toolbar1)

        var toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolBarThree)

        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.demo_ca_menu_1, menu)
        return true
    }

}