package com.example.cse225_codes

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Class_Demo_One_Toolbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_class_demo_one_toolbar)

        //Declare a variable for toolbar
        var toolbar: Toolbar = findViewById(R.id.toolBarOne)
        toolbar.setLogo(R.drawable.img_13)
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Back Arrow", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.demo_menu_one, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.action_email) {
            Toast.makeText(applicationContext, "Email", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.action_info) {
            Toast.makeText(applicationContext, "Search", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.action_alert) {
            Toast.makeText(applicationContext, "Alert", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.setting1) {
            Toast.makeText(applicationContext, "Setting", Toast.LENGTH_SHORT).show()
            return true

        } else if (id == R.id.setting2) {
            Toast.makeText(applicationContext, "Setting 2", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.setting3) {
            Toast.makeText(applicationContext, "Setting 3", Toast.LENGTH_SHORT).show()
            return true
        } else if (id == R.id.exit) {
            Toast.makeText(applicationContext, "Exit", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)


    }
}