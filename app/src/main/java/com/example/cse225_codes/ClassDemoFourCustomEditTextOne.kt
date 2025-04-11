package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityClassDemoFourCustomEditTextOneBinding

class ClassDemoFourCustomEditTextOne : AppCompatActivity() {

    private lateinit var bindings: ActivityClassDemoFourCustomEditTextOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        bindings = ActivityClassDemoFourCustomEditTextOneBinding.inflate(layoutInflater)
        setContentView(bindings.root)

    }
}