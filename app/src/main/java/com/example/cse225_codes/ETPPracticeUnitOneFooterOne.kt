package com.example.cse225_codes

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ETPPracticeUnitOneFooterOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_one_footer_one)

        // Get the XML List
        val listView = findViewById<ListView>(R.id.footerListView3)

        // Make a kotlin list
        val colorsList = arrayOf("Violet", "Red", "Green", "Yellow", "Blue", "Orange")

        // Make an adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, colorsList)

        // Get the footer view
        val footer = layoutInflater.inflate(R.layout.footer_layout_3, listView, false) as ViewGroup

        listView.addFooterView(footer)

        listView.adapter = adapter

    }
}