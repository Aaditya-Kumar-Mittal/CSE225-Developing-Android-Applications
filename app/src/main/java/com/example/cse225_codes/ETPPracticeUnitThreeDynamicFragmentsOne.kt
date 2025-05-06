package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cse225_codes.databinding.ActivityEtppracticeUnitThreeDynamicFragmentsOneBinding

class ETPPracticeUnitThreeDynamicFragmentsOne : AppCompatActivity() {

    private lateinit var binding: ActivityEtppracticeUnitThreeDynamicFragmentsOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEtppracticeUnitThreeDynamicFragmentsOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentBtn1.setOnClickListener { replaceFragment(ETPPracticeFragment1()) }
        binding.fragmentBtn2.setOnClickListener { replaceFragment(ETPPracticeFragment2()) }
        binding.fragmentBtn3.setOnClickListener { replaceFragment(ETPPracticeFragment3()) }
        binding.fragmentBtn4.setOnClickListener { replaceFragment(ETPPracticeFragment4()) }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager4 = supportFragmentManager
        val fragmentTransaction4 = fragmentManager4.beginTransaction()
        fragmentTransaction4.replace(R.id.frameContainer4, fragment)
        fragmentTransaction4.commit()
    }
}