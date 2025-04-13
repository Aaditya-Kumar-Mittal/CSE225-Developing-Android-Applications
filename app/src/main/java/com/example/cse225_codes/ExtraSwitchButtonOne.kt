package com.example.cse225_codes

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse225_codes.databinding.ActivityExtraSwitchButtonOneBinding

class ExtraSwitchButtonOne : AppCompatActivity() {

    private lateinit var binding : ActivityExtraSwitchButtonOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityExtraSwitchButtonOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchButton1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Switch ON", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Switch OFF", Toast.LENGTH_SHORT).show()
            }
        }
        
    }
}