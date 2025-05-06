package com.example.cse225_codes

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityEtppracticeUnitFiveExternalStorageOneBinding
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class ETPPracticeUnitFiveExternalStorageOne : AppCompatActivity() {

    private lateinit var binding: ActivityEtppracticeUnitFiveExternalStorageOneBinding

    // Make a file output streams
    private lateinit var fileOutputStream: FileOutputStream

    private lateinit var myFile: File
    private val fileName = "myETPFile1.txt"
    private val directoryName = "MyETPFileStorage"

    private val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEtppracticeUnitFiveExternalStorageOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etpExternalStorageSaveButton1.setOnClickListener {
            saveData()
        }

    }

    private fun saveData() {
        val data1 = binding.etpExternalStorageInput1.text.toString().trim()
        val data2 = binding.etpExternalStorageInput2.text.toString().trim()

        if (data1.isEmpty() || data2.isEmpty()) {
            Toast.makeText(this, "Field is empty", Toast.LENGTH_SHORT).show()
            return
        }

        try {

            myFile = File(getExternalFilesDir(directoryName), fileName)
            fileOutputStream = FileOutputStream(myFile)
            fileOutputStream.write(data1.toByteArray())
            fileOutputStream.write(data2.toByteArray())
            fileOutputStream.close()
            Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, ETPPracticeUnitFiveExternalStorageReadOne::class.java)
            startActivity(intent)

        } catch (e: Exception) {
            Log.e("FileI/O Exception", "Error: ${e.message}")
            e.printStackTrace()
            Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
        }
    }
}