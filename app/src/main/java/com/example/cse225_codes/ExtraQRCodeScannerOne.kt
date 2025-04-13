package com.example.cse225_codes

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cse225_codes.databinding.ActivityExtraQrcodeScannerOneBinding
import com.journeyapps.barcodescanner.CaptureActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions

class ExtraQRCodeScannerOne : AppCompatActivity() {

    private lateinit var binding: ActivityExtraQrcodeScannerOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityExtraQrcodeScannerOneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showQRScanner1.setOnClickListener {

            val options = ScanOptions()

            options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
            options.setPrompt("Scan a QR Code")
            options.setCameraId(0)
            options.setBeepEnabled(true)
            options.setOrientationLocked(true)
            options.setBarcodeImageEnabled(true)
            options.setCaptureActivity(CaptureActivity::class.java)
            barcodeLauncher.launch(options)
        }
    }

    private val barcodeLauncher = registerForActivityResult(ScanContract()) { result ->
        if (result.contents != null) {
            binding.scannedText1.text = "Scanned: ${result.contents}"
        } else {
            binding.scannedText1.text = "Cancelled"
            Log.d("MainActivity", "Cancelled")
        }
    }
}