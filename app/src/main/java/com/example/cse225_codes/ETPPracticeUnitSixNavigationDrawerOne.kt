package com.example.cse225_codes

import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment

class ETPPracticeUnitSixNavigationDrawerOne : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var fragmentContainer: FrameLayout
    private lateinit var navigationView: com.google.android.material.navigation.NavigationView
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_six_navigation_drawer_one)

        toolbar = findViewById(R.id.etpNavToolbar1)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.etpDrawerLayout1)
        fragmentContainer = findViewById(R.id.fragmentContainer7)
        navigationView = findViewById(R.id.etpNavigationView1)

        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        replaceFragment(ETPPracticeFragment1())

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.etpNavFragmentOption1 -> {
                    replaceFragment(ETPPracticeFragment1())
                    true
                }

                R.id.etpNavFragmentOption2 -> {
                    replaceFragment(ETPPracticeFragment2())
                    true
                }

                R.id.etpNavFragmentOption3 -> {
                    replaceFragment(ETPPracticeFragment3())
                    true
                }

                R.id.etpNavFragmentOption4 -> {
                    replaceFragment(ETPPracticeFragment4())
                    true
                }

                else -> true
            }
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer7, fragment)
        fragmentTransaction.commit()
    }
}