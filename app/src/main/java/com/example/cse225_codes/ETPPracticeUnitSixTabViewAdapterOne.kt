package com.example.cse225_codes

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ETPPracticeUnitSixTabViewAdapterOne(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ETPPracticeFragment1()
            1 -> ETPPracticeFragment2()
            2 -> ETPPracticeFragment3()
            3 -> ETPPracticeFragment4()
            else -> ETPPracticeFragment1()
        }
    }
}