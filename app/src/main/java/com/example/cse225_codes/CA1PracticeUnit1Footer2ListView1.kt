package com.example.cse225_codes

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CA1PracticeUnit1Footer2ListView1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca1_practice_unit1_footer2_list_view1)

        // Get the ListView from XML Layout
        var listView2 = findViewById<ListView>(R.id.footerListView2)

        // Create Data Source or List of Values Kotlin List
        var kotlinList = arrayOf("Violet", "Indigo", "Blue", "Green", "Yellow", "Orange", "Red", "Pink")

        // Create an adapter to populate the ListView, it will connect our data source i.e. kotlinList to the ListView
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, kotlinList)

        // Inflate the footer layout file
        var footer = layoutInflater.inflate(R.layout.footer_layout_2, listView2, false) as ViewGroup

        listView2.addFooterView(footer)

        // Set the adapter to the ListView, Attach the kotlin List Adapter to the ListView of XML
        listView2.adapter = adapter

    }
}