package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2

class ETPPracticeUnitSixSwipeViewOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_six_swipe_view_one)

        val myViewPager = findViewById<ViewPager2>(R.id.etpSwipeView1)

        class First : Fragment(R.layout.fragment_e_t_p_practice1)
        class Second : Fragment(R.layout.fragment_e_t_p_practice2)
        class Third : Fragment(R.layout.fragment_e_t_p_practice3)
        class Fourth : Fragment(R.layout.fragment_e_t_p_practice4)

        val fragmentList = listOf(First(), Second(), Third(), Fourth())

        myViewPager.adapter = ETPPracticeUnitSixSwipeViewAdapterOne(fragmentList, this)
    }
}