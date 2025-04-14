package com.example.cse225_codes

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.cse225_codes.databinding.ActivityExtraNavigationDrawerOneSlideableMenuBinding

class ExtraNavigationDrawerOneSlideableMenu : AppCompatActivity() {

    private lateinit var binding: ActivityExtraNavigationDrawerOneSlideableMenuBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityExtraNavigationDrawerOneSlideableMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(binding.toolbar2)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout1, binding.toolbar2, R.string.open, R.string.close)
        binding.drawerLayout1.addDrawerListener(toggle)
        toggle.syncState()


        binding.navigationView1.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_menu_home1 -> {
                    replaceFragment(ExtraFragment4())
                    true
                }
                R.id.nav_menu_settings1 -> {
                    replaceFragment(ExtraFragment5())
                    true
                }
                R.id.nav_menu_search1 -> {
                    replaceFragment(ExtraFragment6())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer3, fragment)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}
