package com.example.cse225_codes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityEtppracticeUnitFiveExternalStorageReadOneBinding
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

class ETPPracticeUnitFiveExternalStorageReadOne : AppCompatActivity() {

    private lateinit var binding: ActivityEtppracticeUnitFiveExternalStorageReadOneBinding
    private lateinit var fileInputStream: FileInputStream
    private val fileName = "myETPFile1.txt"
    private val directoryName = "MyETPFileStorage"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_etppractice_unit_five_external_storage_read_one)

        binding = ActivityEtppracticeUnitFiveExternalStorageReadOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        readDataFromExternalStorage()

        binding.etpExternalStorageGoBack1.setOnClickListener {
            val intent = Intent(this, ETPPracticeUnitFiveExternalStorageOne::class.java)
            startActivity(intent)
        }
    }

    private fun readDataFromExternalStorage() {
        try {

            val externalFile = File(getExternalFilesDir(directoryName), fileName)
            fileInputStream = FileInputStream(externalFile)

            val inputStreamReader = InputStreamReader(fileInputStream)
            val bufferedReader = BufferedReader(inputStreamReader)

            val stringBuilder = StringBuilder()

            var line: String? = bufferedReader.readLine()

            while (line != null) {
                stringBuilder.append(line).append("\n")
                line = bufferedReader.readLine()
            }

            bufferedReader.close()
            inputStreamReader.close()
            fileInputStream.close()

            binding.etpExternalStorageReadText1.text = stringBuilder.toString().trim()
            Toast.makeText(this, "Data read", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            Log.e("FileI/O Exception", "Error: ${e.message}")
            e.printStackTrace()
            Toast.makeText(this, "Failed to read data", Toast.LENGTH_SHORT).show()
        }
    }
}