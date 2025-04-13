package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.cse225_codes.databinding.ActivityExtraBottomNavigationBarOneBinding

class ExtraBottomNavigationBarOne : AppCompatActivity() {

    private lateinit var binding: ActivityExtraBottomNavigationBarOneBinding

    private lateinit var fragmentManager3: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityExtraBottomNavigationBarOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView2.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home1 -> {
                    replaceFragments(ExtraFragment4())
                    true
                }

                R.id.menu_settings1 -> {
                    replaceFragments(ExtraFragment6())
                    true
                }

                R.id.menu_profile1 -> {
                    replaceFragments(ExtraFragment7())
                    true
                }

                R.id.menu_cart1 -> {
                    replaceFragments(ExtraFragment8())
                    true
                }

                else -> {
                    false
                }
            }
        }
    }

    private fun replaceFragments(fragment: Fragment) {
        fragmentManager3 = supportFragmentManager
        fragmentManager3.beginTransaction().replace(R.id.frameContainer2, fragment).commit()
    }

}