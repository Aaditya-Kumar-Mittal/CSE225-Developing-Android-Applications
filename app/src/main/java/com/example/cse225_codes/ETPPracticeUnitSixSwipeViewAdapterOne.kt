package com.example.cse225_codes

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// List<Fragment>: A list of fragments we'll swipe through.
// FragmentActivity: The activity where the ViewPager lives. Required for managing fragment lifecycles.
// This class extends FragmentStateAdapter, which is the adapter used with ViewPager2 when showing fragments.
class ETPPracticeUnitSixSwipeViewAdapterOne(private val fragmentList: List<Fragment>, activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = fragmentList.size

    //This function is called every time ViewPager needs a new fragment for a page.
    //It returns the correct fragment from the list for the given position (e.g., 0 for first, 1 for second, etc).
    override fun createFragment(position: Int): Fragment = fragmentList[position]

}







