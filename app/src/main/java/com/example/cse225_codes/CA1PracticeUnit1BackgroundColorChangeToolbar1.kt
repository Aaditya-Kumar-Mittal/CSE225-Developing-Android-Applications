package com.example.cse225_codes

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CA1PracticeUnit1BackgroundColorChangeToolbar1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ca1_practice_unit1_background_color_change_toolbar1)

        val violetColorBtn = findViewById<CardView>(R.id.violetColorBtn2)
        val indigoColorBtn = findViewById<CardView>(R.id.indigoColorBtn2)
        val blueColorBtn = findViewById<CardView>(R.id.blueColorBtn2)
        val greenColorBtn = findViewById<CardView>(R.id.greenColorBtn2)
        val yellowColorBtn = findViewById<CardView>(R.id.yellowColorBtn2)
        val orangeColorBtn = findViewById<CardView>(R.id.orangeColorBtn2)
        val redColorBtn = findViewById<CardView>(R.id.redColorBtn2)
        val pinkColorBtn = findViewById<CardView>(R.id.pinkColorBtn2)
        val linearLayout = findViewById<LinearLayout>(R.id.backgroundColorChangeToolbar2)

        violetColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.violet_500))
        }

        indigoColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.indigo_500))
        }

        blueColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.blue_500))
        }


        greenColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.green_500))
        }


        yellowColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.yellow_500))
        }

        orangeColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.orange_500))
        }

        redColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.red_500))
        }

        pinkColorBtn.setOnClickListener {
            linearLayout.setBackgroundColor(resources.getColor(R.color.pink_500))
        }
    }
}