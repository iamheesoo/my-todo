package com.toy.mytodo.calendar.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.toy.mytodo.view.CalendarFragment

class CalendarAdapter(f: Fragment) : FragmentStateAdapter(f) {
    override fun createFragment(position: Int): Fragment {
        return CalendarFragment.newInstance(position)
    }

    override fun getItemCount(): Int {
        return 10
    }


}