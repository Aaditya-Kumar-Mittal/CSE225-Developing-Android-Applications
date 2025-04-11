package com.example.cse225_codes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityClassDemoFiveExternalStorageFetchDetailsOneBinding
import java.io.*

class ClassDemoFiveExternalStorageFetchDetailsOne : AppCompatActivity() {

    private lateinit var binding: ActivityClassDemoFiveExternalStorageFetchDetailsOneBinding

    private val fileName = "myFile2.txt"
    private val directoryName = "MyFileStorage"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityClassDemoFiveExternalStorageFetchDetailsOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Fetch and display data from external storage
        readDataFromExternalStorage()

        // Go back button
        binding.goBack1.setOnClickListener {
            val intent = Intent(this, ClassDemoFiveExternalStorageFileInputOutputOne::class.java)
            startActivity(intent)
        }
    }

    private fun readDataFromExternalStorage() {
        try {
            val externalFile = File(getExternalFilesDir(directoryName), fileName)
            val fileInputStream = FileInputStream(externalFile)
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

            binding.fetchDetails1.text = stringBuilder.toString().trim()

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            Log.e("ReadError", "File not found: ${e.message}")
            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show()
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("ReadError", "IO Error: ${e.message}")
            Toast.makeText(this, "Error reading file", Toast.LENGTH_SHORT).show()
        }
    }
}
