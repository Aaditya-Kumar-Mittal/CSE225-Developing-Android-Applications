package com.example.cse225_codes

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.FileInputStream
import java.io.FileOutputStream

class ETPPracticeUnitFiveInternalStorageOne : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var writeBtn: Button
    private lateinit var readBtn: Button

    private var fileName = "etp_internal_storage_one"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_five_internal_storage_one)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText = findViewById(R.id.etpInternalStorageInput1)
        textView = findViewById(R.id.etpInternalStorageReadText1)
        writeBtn = findViewById(R.id.etpWriteInternalStorage1)
        readBtn = findViewById(R.id.etpReadInternalStorage1)

        writeBtn.setOnClickListener {
            writeData()
        }

        readBtn.setOnClickListener {
            readData()
        }
    }

    private fun readData() {
        try {
            // Make a FileInputStream
            val fileInputStream: FileInputStream = openFileInput(fileName)
            val dataRead = fileInputStream.readBytes()
            val data = String(dataRead)
            textView.text = data
            fileInputStream.close()

        } catch (e: Exception) {
            Log.e("Error", e.toString())
            e.printStackTrace()
        }
    }

    private fun writeData() {
        try {
            val fileOutputStream: FileOutputStream = openFileOutput(fileName, Context.MODE_PRIVATE)
            fileOutputStream.write(editText.text.toString().toByteArray())
            Toast.makeText(this, "Data written in internal storage.", Toast.LENGTH_SHORT).show()
            fileOutputStream.close()
        } catch (e: Exception) {
            Log.e("Error", e.toString())
            e.printStackTrace()
        }
    }
}