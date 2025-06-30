package ru.app.mobilki.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.app.mobilki.ui.fragments.MyActivityFragment
import ru.app.mobilki.ui.fragments.UsersActivityFragment

class ActivityPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2
    override fun createFragment(position: Int): Fragment = when (position) {
        0 -> MyActivityFragment()
        1 -> UsersActivityFragment()
        else -> throw IllegalArgumentException()
    }
} 