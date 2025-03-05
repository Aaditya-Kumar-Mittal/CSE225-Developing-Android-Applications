package com.example.cse225_codes

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ClassDemoOneFooter2BottomNav1 : AppCompatActivity() {

    private lateinit var textView : TextView
    private lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_footer2_bottom_nav1)

        textView = findViewById(R.id.textview6)
        bottomNav = findViewById(R.id.footerBottomNav1)


        bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    textView.text = "Home"
                    true
                }
                R.id.menu_notification -> {
                    textView.text = "Notification"
                    true
                }
                R.id.menu_search -> {
                    textView.text = "Search"
                    true
                }
                R.id.menu_Profile -> {
                    textView.text = "Profile"
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}