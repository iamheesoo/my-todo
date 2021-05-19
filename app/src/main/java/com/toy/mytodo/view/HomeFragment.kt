package com.toy.mytodo.view

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.toy.mytodo.calendar.adapter.CalendarAdapter
import com.toy.mytodo.databinding.FragmentHomeBinding
import com.toy.mytodo.viewmodel.TaskViewModel
import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

class HomeFragment(application: Application) : Fragment() {
    private val TAG="HomeFragment"
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentHomeBinding.inflate(layoutInflater, container, false)
        binding.viewpager.adapter=CalendarAdapter(this)
//        view.viewpager.currentItem = 5

        return binding.root
    }


}