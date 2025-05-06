package com.example.cse225_codes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment


class ETPFragmentDataTransfer1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val dataTransferView1 = inflater.inflate(R.layout.fragment_e_t_p_data_transfer1, container, false)
        val fragmentInput = dataTransferView1.findViewById<EditText>(R.id.fragmentDataTransferInput1)
        val fragmentSendButton = dataTransferView1.findViewById<Button>(R.id.fragmentDataSendButton1)

        fragmentSendButton.setOnClickListener {

            // Get the input and convert it to string
            val text = fragmentInput.text.toString()

            val receiverFragment = ETPFragmentDataTransfer2()
            val bundle = Bundle()
            bundle.putString("data", text)  // Stores the string with key data in the bundle
            receiverFragment.arguments = bundle // Assigns the bundle to the second fragment's arguments so that the second fragment can access the data via the fragments

            // Replace the current fragment with the second fragment
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer5, receiverFragment).addToBackStack(null).commit()

        }

        return dataTransferView1
    }

}