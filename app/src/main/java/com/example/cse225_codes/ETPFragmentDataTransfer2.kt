package com.example.cse225_codes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ETPFragmentDataTransfer2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dataReceiverView1 = inflater.inflate(R.layout.fragment_e_t_p_data_transfer2, container, false)
        val dataReceiverText = dataReceiverView1.findViewById<TextView>(R.id.fragmentDataReceiverText1)

        // Obtain the data from the bundle
        val getBundleData = arguments?.getString("data")
        dataReceiverText.text = getBundleData ?: "No data received"

        return dataReceiverView1
    }
}