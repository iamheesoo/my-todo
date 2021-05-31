package com.toy.mytodo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.toy.mytodo.MyApp
import com.toy.mytodo.databinding.ActivityAddBinding
import com.toy.mytodo.repository.dto.Task
import com.toy.mytodo.viewmodel.TaskViewModel
import org.joda.time.DateTime

class AddActivity : AppCompatActivity() {
    private lateinit var binding:ActivityAddBinding
    private val TAG="AddActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            sendResult(binding.calendarMonth.date, binding.etTask.text.toString())
        }
    }

    private fun sendResult(time: Long, task: String){
        val date=DateTime(time).toString("yyyy-MM-dd")
        val intent= Intent()
        intent.putExtra(MainActivity.DATA_TASK, Task(date=date, content=task))
        setResult(RESULT_OK, intent)
        finish()
    }

}