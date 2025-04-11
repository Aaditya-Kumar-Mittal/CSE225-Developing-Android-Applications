package com.example.cse225_codes

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.cse225_codes.databinding.ActivityClassDemoFiveExternalStorageImageDisplayOneBinding
import java.io.File

class ClassDemoFiveExternalStorageImageDisplayOne : AppCompatActivity() {
    private lateinit var binding: ActivityClassDemoFiveExternalStorageImageDisplayOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityClassDemoFiveExternalStorageImageDisplayOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imagePath = intent.getStringExtra("image_path")
        Log.d("ImagePathDebug", "Image path received: $imagePath")

        if (imagePath != null) {
            val imgFile = File(imagePath)
            if (imgFile.exists()) {
                val bitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
                binding.displayImageView1.setImageBitmap(bitmap)
            } else {
                Toast.makeText(this, "Image file not found", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Image path is null", Toast.LENGTH_SHORT).show()
        }
    }
}
