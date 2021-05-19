package com.toy.mytodo.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.toy.mytodo.repository.TaskRepository
import com.toy.mytodo.repository.dto.Task
import org.joda.time.DateTime

class TaskViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG="TaskViewModel"
    private val repository=TaskRepository(application)
    private val tasks=repository.getAll(DateTime.now().toString("yyyy-MM-dd"))

    val selectedDate= MutableLiveData<DateTime>()

    fun setDateTime(dateTime: DateTime){
        selectedDate.value=dateTime
//        selectedDate.postValue(dateTime)
        /**
         * DB에서 해당날짜 task 불러와서 업데이트
         */
        repository.getAll(dateTime.toString("yyyy-MM-dd"))
    }

    fun insert(task: Task)=repository.insert(task)

    fun delete(task: Task)=repository.delete(task)

    class Factory(val application: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TaskViewModel(application) as T
        }
    }

}