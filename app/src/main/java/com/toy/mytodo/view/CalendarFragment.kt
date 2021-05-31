package com.toy.mytodo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.toy.mytodo.calendar.util.CalendarUtils
import com.toy.mytodo.calendar.view.DayItemView
import com.toy.mytodo.databinding.FragmentCalendarBinding
import org.joda.time.DateTime

class CalendarFragment: Fragment()  {
    private val TAG="CalendarFragment"
    private var millis: Long=0L
    private lateinit var binding: FragmentCalendarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{
            millis=it.getLong(MILLIS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentCalendarBinding.inflate(layoutInflater, container, false)

        val listener=object : DayItemView.EventListener {
            override fun onItemClick(dateTime: DateTime) {
                Log.i(TAG, dateTime.toString("yyyy-MM-dd"))
//                viewModel.setDateTime(dateTime)
            }
        }

        binding.tvCalendar.text=DateTime(millis).toString("yyyy-MM")
        binding.calendarView.initCalendar(
            DateTime(millis),
            CalendarUtils.getWeekList(DateTime(millis)),
            listener
        )

        return binding.root
    }

    companion object {
        private const val MILLIS="MILLIS"

        fun newInstance(position: Int)= CalendarFragment().apply {
            Log.i(TAG, position.toString())
//            arguments= Bundle().apply { putLong(MILLIS, DateTime.now().millis+(position-5)*86400000*7) }
            arguments= Bundle().apply { putLong(MILLIS, DateTime.now().millis+position*86400000*7) }
        }

    }
}