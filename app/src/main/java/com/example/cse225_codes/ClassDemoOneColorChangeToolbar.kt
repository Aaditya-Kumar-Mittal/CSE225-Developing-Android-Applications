package com.example.cse225_codes

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ClassDemoOneColorChangeToolbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_color_change_toolbar)

        val blueColorBtn = findViewById<CardView>(R.id.blueColorBtn1)
        val greenColorBtn = findViewById<CardView>(R.id.greenColorBtn1)
        val yellowColorBtn = findViewById<CardView>(R.id.yellowColorBtn1)
        val violetColorBtn = findViewById<CardView>(R.id.violetColorBtn1)
        val pinkColorBtn = findViewById<CardView>(R.id.pinkColorBtn1)
        val limeColorBtn = findViewById<CardView>(R.id.limeColorBtn1)
        val orangeColorBtn = findViewById<CardView>(R.id.orangeColorBtn1)
        val fuchsiaColorBtn = findViewById<CardView>(R.id.fuchsiaColorBtn1)
        val skyColorBtn = findViewById<CardView>(R.id.skyColorBtn1)

        var linearLayout = findViewById<LinearLayout>(R.id.changeBackgroundColorToolbar)

        blueColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.blue_500))
        }

        greenColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.green_500))
        }

        yellowColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.yellow_500))
        }

        violetColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.violet_500))
        }

        pinkColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.pink_500))
        }


        limeColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.lime_500))
        }

        orangeColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.orange_500))
        }


        fuchsiaColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.fuchsia_500))
        }

        skyColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.sky_500))
        }

    }
}