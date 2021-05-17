package com.toy.mytodo.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.toy.mytodo.R
import com.toy.mytodo.calendar.adapter.CalendarAdapter
import com.toy.mytodo.calendar.util.CalendarUtils.Companion.getWeekList
import com.toy.mytodo.calendar.view.CalendarFragment
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.joda.time.DateTime

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_home, container, false)
        view.viewpager.adapter=CalendarAdapter(this)
//        view.viewpager.currentItem = 5
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}