package com.example.cse225_codes

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassDemoOneFooter1ListView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_footer1_list_view)

        // Get the ListView from XML Layout
        val footerListView = findViewById<ListView>(R.id.footerListView1)

        // Create a list of strings
        val footerList = arrayOf(
            "Custom Toast", "Progress Bar", "Toolbar", "Splash Screen", "Ratings Bar"
        )

        // Create an adapter to populate the ListView, it will connect our data source i.e. footerList to the ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, footerList)

        // Inflate the footer file
        val footer = layoutInflater.inflate(R.layout.footer_layout, footerListView, false) as ViewGroup

        // Add the footer to the ListView
        footerListView.addFooterView(footer)

        // Set the adapter to the ListView
        footerListView.adapter = adapter

    }
}