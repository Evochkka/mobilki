package ru.app.mobilki

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class ActivityPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> MyActivityFragment()
        1 -> UsersActivityFragment()
        else -> throw IllegalArgumentException()
    }
} 