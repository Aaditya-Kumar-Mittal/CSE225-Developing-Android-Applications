package com.example.cse225_codes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityClassDemoFiveExternalStorageImageInputOneBinding
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class ClassDemoFiveExternalStorageImageInputOne : AppCompatActivity() {
    private lateinit var binding: ActivityClassDemoFiveExternalStorageImageInputOneBinding
    private lateinit var imageFile: File
    private val imageFileName = "myImage.jpg"

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            saveImageToExternalStorage(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityClassDemoFiveExternalStorageImageInputOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pickImageButton.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        binding.goToDisplayActivity.setOnClickListener {
            val imageFile = File(getExternalFilesDir("ImageStorage"), imageFileName)
            if (imageFile.exists()) {
                val intent = Intent(this, ClassDemoFiveExternalStorageImageDisplayOne::class.java)
                intent.putExtra("image_path", imageFile.absolutePath)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select and save an image first", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun saveImageToExternalStorage(uri: Uri) {
        try {
            val inputStream: InputStream? = contentResolver.openInputStream(uri)
            imageFile = File(getExternalFilesDir("ImageStorage"), imageFileName)
            val outputStream = FileOutputStream(imageFile)

            val buffer = ByteArray(1024)
            var bytesRead: Int
            while (inputStream!!.read(buffer).also { bytesRead = it } != -1) {
                outputStream.write(buffer, 0, bytesRead)
            }

            outputStream.close()
            inputStream.close()

            Log.d("ImageSave", "Image saved at: ${imageFile.absolutePath}")
            Toast.makeText(this, "Image Saved Successfully!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("ImageSaveError", "Error: ${e.message}")
            Toast.makeText(this, "Failed to Save Image", Toast.LENGTH_SHORT).show()
        }
    }
}
