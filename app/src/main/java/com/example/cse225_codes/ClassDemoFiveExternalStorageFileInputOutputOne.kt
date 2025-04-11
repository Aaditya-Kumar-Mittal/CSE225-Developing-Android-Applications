package com.example.cse225_codes

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityClassDemoFiveExternalStorageFileInputOutputOneBinding
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

class ClassDemoFiveExternalStorageFileInputOutputOne : AppCompatActivity() {

    private lateinit var binding: ActivityClassDemoFiveExternalStorageFileInputOutputOneBinding
    private lateinit var fileOutputStream: FileOutputStream
    private lateinit var myExternalFile: File

    private val fileName = "myFile2.txt"
    private val directoryName = "MyFileStorage"

    private val permissions = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityClassDemoFiveExternalStorageFileInputOutputOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveDataExternal1.setOnClickListener {
            val username = binding.inputName1.text.toString().trim()
            val password = binding.inputPassword1.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Field is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            try {
                myExternalFile = File(getExternalFilesDir(directoryName), fileName)
                fileOutputStream = FileOutputStream(myExternalFile)

                // Writing with a delimiter for better data separation
                val content = "$username\n$password"
                fileOutputStream.write(content.toByteArray())
                fileOutputStream.close()

                Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show()

                // Navigate to next activity
                val intent = Intent(this, ClassDemoFiveExternalStorageFetchDetailsOne::class.java)
                startActivity(intent)

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
                Log.e("FileI/O Exception", "File not found: ${e.message}")
                Toast.makeText(this, "Failed to save data", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("FileI/O Exception", "Error: ${e.message}")
                Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
