package com.toy.mytodo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.toy.mytodo.repository.TaskRepository
import com.toy.mytodo.repository.dto.Task
import org.joda.time.DateTime

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG="TaskViewModel"
    private val repository=TaskRepository(application)

    private val _selectedDate= MutableLiveData<DateTime>()
    val selectedDate: LiveData<DateTime>
    get()=_selectedDate

    val tasks: LiveData<List<Task>> = Transformations.switchMap(selectedDate) { date ->
        Log.d(TAG, "switchMap")
        repository.getAllByDate(date.toString("yyyy-MM-dd"))
    }

    fun getAll():LiveData<List<Task>>{
        return this.tasks
    }

    fun setSelectedDate(dateTime: DateTime){
        _selectedDate.value = dateTime
        Log.d(TAG, dateTime.toString("yyyy-MM-dd"))
    }

    fun insert(task: Task)=repository.insert(task)

    fun delete(task: Task)=repository.delete(task)

}