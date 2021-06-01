package com.toy.mytodo.repository.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.toy.mytodo.repository.dto.Task

@Dao
interface TaskDao {
    @Query("SELECT * FROM TASK ORDER BY date ASC")
    fun findAll():LiveData<List<Task>>

    @Query("SELECT * FROM TASK WHERE date == :date ORDER BY date ASC")
    fun findAllByDate(date: String): LiveData<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)
}