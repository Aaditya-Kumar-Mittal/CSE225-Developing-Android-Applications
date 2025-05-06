package com.example.cse225_codes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ETPPracticeUnitThreeDynamicFragmentsDataTransferOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_three_dynamic_fragments_data_transfer_one)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer5, ETPFragmentDataTransfer1()).commit()
    }
}