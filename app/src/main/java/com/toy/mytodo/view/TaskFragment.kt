package com.toy.mytodo.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.toy.mytodo.adapter.TaskAdapter
import com.toy.mytodo.databinding.FragmentTaskBinding
import com.toy.mytodo.repository.dto.Task
import com.toy.mytodo.viewmodel.TaskViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class TaskFragment:Fragment() {
    private val TAG="TaskFragment"
    private lateinit var binding: FragmentTaskBinding
    private val taskViewModel by sharedViewModel<TaskViewModel>() // activityViewModels<TaskViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentTaskBinding.inflate(layoutInflater, container, false)

//        binding.lifecycleOwner=this
        binding.viewModel=taskViewModel
        val mAdapter=TaskAdapter()
        binding.recyclerTask.adapter=mAdapter

        taskViewModel.tasks.observe(viewLifecycleOwner, Observer<List<Task>> {
            mAdapter.submitList(it)
        })

        return binding.root
    }

}