package com.toy.mytodo.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.toy.mytodo.repository.dao.TaskDao
import com.toy.mytodo.repository.database.TaskDatabase
import com.toy.mytodo.repository.dto.Task
import java.lang.Exception

class TaskRepository(application: Application) {
    private val TAG="TaskRepository"
    private val taskDatabase: TaskDatabase= TaskDatabase.getInstance(application)!!
    private val taskDao: TaskDao =taskDatabase.taskDao()
    private val tasks=taskDao.findAll()

    fun getAll(): LiveData<List<Task>>{
        return tasks
    }

    fun getAll(date: String): LiveData<List<Task>>{
        return taskDao.findAllByDate(date)
    }

    fun insert(task: Task){
        try{
            val thread=Thread(Runnable {
                taskDao.insert(task)
            })
            thread.start()
        } catch (e: Exception){
            Log.w(TAG, e.message.toString())
        }
    }

    fun delete(task: Task){
        try{
            val thread=Thread(Runnable {
                taskDao.delete(task)
            })
            thread.start()
        } catch (e: Exception){
            Log.w(TAG, e.message.toString())
        }
    }

}