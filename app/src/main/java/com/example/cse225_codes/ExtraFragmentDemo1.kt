package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.cse225_codes.databinding.ActivityExtraFragmentDemo1Binding

class ExtraFragmentDemo1 : AppCompatActivity() {

    private lateinit var binding: ActivityExtraFragmentDemo1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExtraFragmentDemo1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentBtn1.setOnClickListener {
            replaceFragment(ExtraFragment1())
        }

        binding.fragmentBtn2.setOnClickListener {
            replaceFragment(ExtraFragment2())
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.extraFragment1, fragment)
        fragmentTransaction.commit()
    }
}