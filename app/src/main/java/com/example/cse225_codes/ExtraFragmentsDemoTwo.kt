package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.cse225_codes.databinding.ActivityExtraFragmentsDemoTwoBinding

class ExtraFragmentsDemoTwo : AppCompatActivity() {

    private lateinit var binding: ActivityExtraFragmentsDemoTwoBinding

    private lateinit var fragmentManager2 : FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityExtraFragmentsDemoTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonFor1.setOnClickListener { changeFragment(ExtraFragment4()) }
        binding.buttonFor2.setOnClickListener { changeFragment(ExtraFragment5()) }
        binding.buttonFor3.setOnClickListener { changeFragment(ExtraFragment6()) }
        binding.buttonFor4.setOnClickListener { changeFragment(ExtraFragment7()) }
        binding.buttonFor5.setOnClickListener { changeFragment(ExtraFragment8()) }
        binding.buttonFor6.setOnClickListener { changeFragment(ExtraFragment9()) }
        binding.buttonFor7.setOnClickListener { changeFragment(ExtraFragment10()) }

    }

    private fun changeFragment(fragment: Fragment)
    {
        fragmentManager2 = supportFragmentManager

        fragmentManager2.beginTransaction().replace(R.id.fragmentContainer1,fragment).commit()

    }
}