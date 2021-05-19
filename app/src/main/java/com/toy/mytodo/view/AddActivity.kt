package com.toy.mytodo.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.toy.mytodo.MyApp
import com.toy.mytodo.databinding.ActivityAddBinding
import com.toy.mytodo.repository.dto.Task
import com.toy.mytodo.viewmodel.TaskViewModel
import org.joda.time.DateTime

class AddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddBinding
//    private lateinit var taskViewModel: TaskViewModel
    private val taskViewModel by lazy {
        ViewModelProvider(this, TaskViewModel.Factory(MyApp.getInstance())).get(TaskViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        taskViewModel= ViewModelProviders.of(this).get(TaskViewModel::class.java)

        binding.btnAdd.setOnClickListener {
            insertTask(binding.calendarMonth.date, binding.etTask.text.toString())
        }
    }

    private fun insertTask(time: Long, task: String){
        val date=DateTime(time).toString("yyyy-MM-dd")
        taskViewModel.insert(Task(null, date, task, false))
    }

}