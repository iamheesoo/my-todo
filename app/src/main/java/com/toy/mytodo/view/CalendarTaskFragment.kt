package com.toy.mytodo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.toy.mytodo.MyApp
import com.toy.mytodo.calendar.util.CalendarUtils
import com.toy.mytodo.calendar.view.DayItemView
import com.toy.mytodo.databinding.FragmentCalendarBinding
import com.toy.mytodo.viewmodel.TaskViewModel
import org.joda.time.DateTime

class CalendarTaskFragment: Fragment()  {
    private val TAG="CalendarFragment"
    private var millis: Long=0L
    private lateinit var binding: FragmentCalendarBinding
    private val viewModel: TaskViewModel by lazy{
        ViewModelProvider(this, TaskViewModel.Factory(MyApp.getInstance())).get(TaskViewModel::class.java)
    }

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
                viewModel.setDateTime(dateTime)
            }
        }

        binding.tvCalendar.text=DateTime(millis).toString("yyyy-MM")
        binding.calendarView.initCalendar(
            DateTime(millis),
            CalendarUtils.getWeekList(DateTime(millis)),
            listener
        )

        viewModel.selectedDate.observe(this, Observer {
            binding.tvDay.text=it.toString()
        })

        return binding.root
    }

    companion object {
        private const val MILLIS="MILLIS"

        fun newInstance(position: Int)= CalendarTaskFragment().apply {
            Log.i(TAG, position.toString())
//            arguments= Bundle().apply { putLong(MILLIS, DateTime.now().millis+(position-5)*86400000*7) }
            arguments= Bundle().apply { putLong(MILLIS, DateTime.now().millis+position*86400000*7) }
        }

    }
}