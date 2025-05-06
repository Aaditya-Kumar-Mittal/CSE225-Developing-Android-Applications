package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ETPPracticeUnitOneToolbarOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_one_toolbar_one)

        val toolbar =  findViewById<Toolbar>(R.id.toolbar6)
        setSupportActionBar(toolbar)

    }
}