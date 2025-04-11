package com.example.cse225_codes

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityClassDemoFiveFileOperationsOneBinding
import java.io.FileInputStream
import java.io.FileOutputStream

class ClassDemoFiveFileOperationsOne : AppCompatActivity() {

    private lateinit var bindings: ActivityClassDemoFiveFileOperationsOneBinding
    private val myFileName1 = "myFile1.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindings = ActivityClassDemoFiveFileOperationsOneBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        bindings.writeToFileButton1.setOnClickListener {
            try {
                val data1 = bindings.numberInput1.text.toString().toDouble()
                val data2 = bindings.numberInput2.text.toString().toDouble()
                val product = data1 * data2

                // Create output file stream for writing
                val fileOutputStream1: FileOutputStream = openFileOutput(myFileName1, MODE_PRIVATE)
                fileOutputStream1.write("The product is $product".toByteArray())
                fileOutputStream1.close()

                Toast.makeText(this, "Data written to file", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("FileOperations", "Error writing to file: ${e.message}")
            }
        }

        bindings.readFileButton1.setOnClickListener {
            try {
                val fileInputStream1: FileInputStream = openFileInput(myFileName1)
                val data = fileInputStream1.bufferedReader().use { it.readText() }
                fileInputStream1.close()

                bindings.displayProduct1.text = data
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("FileOperations", "Error reading from file: ${e.message}")
            }
        }
    }
}