package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ETPPracticeUnitSixTabViewOne : AppCompatActivity() {

    private lateinit var tabLayout1: TabLayout
    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerAdapter: ETPPracticeUnitSixTabViewAdapterOne

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_six_tab_view_one)

        tabLayout1 = findViewById(R.id.etpTabLayout1)
        viewPager2 = findViewById(R.id.etpViewPager2)
        viewPagerAdapter = ETPPracticeUnitSixTabViewAdapterOne(this)
        viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout1, viewPager2) { tab, position ->
            when (position) {
                0 -> tab.text = "Tab 1"
                1 -> tab.text = "Tab 2"
                2 -> tab.text = "Tab 3"
                3 -> tab.text = "Tab 4"
                4 -> tab.text = "Tab 5"
                5 -> tab.text = "Tab 6"
            }
        }.attach()

    }
}