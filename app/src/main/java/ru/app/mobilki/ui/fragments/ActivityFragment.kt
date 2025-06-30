package ru.app.mobilki.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ru.app.mobilki.R
import ru.app.mobilki.ui.activities.MainScreenActivity
import ru.app.mobilki.ui.adapters.ActivityPagerAdapter

class ActivityFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val adapter = ActivityPagerAdapter(this)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                (requireActivity() as? MainScreenActivity)?.onActivityTabChanged(position)
            }
        })
        
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Моя"
                1 -> "Пользователей"
                else -> ""
            }
        }.attach()
    }
} 