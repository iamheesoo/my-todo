package com.toy.mytodo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.toy.mytodo.adapter.TaskAdapter
import com.toy.mytodo.databinding.FragmentTaskBinding
import com.toy.mytodo.repository.dto.Task
import com.toy.mytodo.viewmodel.TaskViewModel

class TaskFragment:Fragment() {
    private val TAG="TaskFragment"
    private lateinit var binding: FragmentTaskBinding
    private val taskViewModel by viewModels<TaskViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentTaskBinding.inflate(layoutInflater, container, false)

//        binding.lifecycleOwner=this
        binding.viewModel=taskViewModel
        val mAdapter=TaskAdapter()
        binding.recyclerTask.apply {
            adapter=mAdapter
            setHasFixedSize(true)
        }

        taskViewModel.getAll().observe(viewLifecycleOwner, Observer<List<Task>> {
            mAdapter.setTasks(it!!)
        })

        return binding.root
    }

}