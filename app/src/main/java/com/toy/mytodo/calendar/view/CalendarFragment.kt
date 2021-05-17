package com.toy.mytodo.calendar.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.toy.mytodo.R
import com.toy.mytodo.calendar.adapter.CalendarAdapter
import com.toy.mytodo.calendar.util.CalendarUtils
import com.toy.mytodo.view.HomeFragment
import kotlinx.android.synthetic.main.fragment_calendar.view.*
import org.joda.time.DateTime

class CalendarFragment: Fragment()  {
    private var millis: Long=0L
    private val TAG="CalendarFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            millis=it.getLong(MILLIS)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_calendar, container, false)
        view.tv_calendar.text=DateTime(millis).toString("yyyy-MM")
        view.calendar_view.initCalendar(
            DateTime(millis),
            CalendarUtils.getWeekList(DateTime(millis))
        )

        return view
    }

    companion object {
        private const val MILLIS="MILLIS"

        fun newInstance(position: Int)=CalendarFragment().apply {
            Log.i(TAG, position.toString())
//            arguments= Bundle().apply { putLong(MILLIS, DateTime.now().millis+(position-5)*86400000*7) }
            arguments= Bundle().apply { putLong(MILLIS, DateTime.now().millis+position*86400000*7) }
        }

    }
}