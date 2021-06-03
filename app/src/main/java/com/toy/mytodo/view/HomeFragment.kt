package com.toy.mytodo.view

import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.toy.mytodo.calendar.adapter.CalendarAdapter
import com.toy.mytodo.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
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