package com.example.cse225_codes

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ClassDemoSixTabViewAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    private val fragments = listOf(
        ExtraFragmentHome(),
        ExtraFragmentCamera(),
        ExtraFragmentContact()
    )

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}