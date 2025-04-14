package com.example.cse225_codes

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.cse225_codes.databinding.ActivityExtraNavigationDrawerTwoBinding

class ExtraNavigationDrawerTwo : AppCompatActivity() {

    private lateinit var binding: ActivityExtraNavigationDrawerTwoBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityExtraNavigationDrawerTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up toolbar *before* enabling home button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setSupportActionBar(binding.toolbar5)


        // Set up the ActionBarDrawerToggle
        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout2,
            binding.toolbar5,
            R.string.open,
            R.string.close
        )
        binding.drawerLayout2.addDrawerListener(toggle)
        toggle.syncState()

        // Navigation item click listener
        binding.navigationView2.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> replaceFragment(ExtraFragment4())
                R.id.nav_settings -> replaceFragment(ExtraFragment5())
                R.id.nav_about -> replaceFragment(ExtraFragment6())
                R.id.nav_logout -> replaceFragment(ExtraFragment7())
                R.id.nav_share -> replaceFragment(ExtraFragment8())
                else -> return@setNavigationItemSelectedListener false
            }
            binding.drawerLayout2.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer2, fragment)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item)
    }
}
