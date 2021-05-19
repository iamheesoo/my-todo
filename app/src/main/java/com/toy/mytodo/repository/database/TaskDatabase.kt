package com.toy.mytodo.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.toy.mytodo.repository.dao.TaskDao
import com.toy.mytodo.repository.dto.Task

@Database(entities = [Task::class], version=1)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object{
        private var INSTANCE: TaskDatabase?=null

        fun getInstance(context: Context): TaskDatabase?{
            if(INSTANCE==null){
                synchronized(TaskDatabase::class){
                    INSTANCE= Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "task-database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return INSTANCE
        }
    }
}