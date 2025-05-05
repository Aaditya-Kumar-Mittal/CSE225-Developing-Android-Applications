package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityClassDemoSixTabViewBinding
import com.google.android.material.tabs.TabLayoutMediator

class ClassDemoSixTabView : AppCompatActivity() {

    private lateinit var binding: ActivityClassDemoSixTabViewBinding
    private lateinit var adapter: ClassDemoSixTabViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityClassDemoSixTabViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ClassDemoSixTabViewAdapter(this)
        binding.myViewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout1, binding.myViewPager2) { tab, position ->
            tab.text = when (position) {
                0 -> "Home"
                1 -> "Camera"
                2 -> "Contact"
                else -> "Home"
            }
        }.attach()

    }
}