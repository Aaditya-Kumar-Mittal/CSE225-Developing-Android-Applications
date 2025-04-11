package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.cse225_codes.databinding.ActivityClassDemoSixSwipeViewOneBinding

class ClassDemoSixSwipeViewOne : AppCompatActivity() {

    private lateinit var binding: ActivityClassDemoSixSwipeViewOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityClassDemoSixSwipeViewOneBinding.inflate(layoutInflater)

        setContentView(binding.root)

        class FirstFragment : Fragment(R.layout.extra_fragment_layout_1)
        class SecondFragment : Fragment(R.layout.extra_fragment_layout_2)
        class ThirdFragment : Fragment(R.layout.fragment_extra3)

        val fragmentList = listOf(
            FirstFragment(),
            SecondFragment(),
            ThirdFragment()
        )

        binding.myViewPager1.adapter = ClassDemoSixSwipeViewOneViewPagerClassOne(fragmentList, this)
    }
}