package com.toy.mytodo.repository.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "TASK")
data class Task(
    @PrimaryKey(autoGenerate = true)
    var id: Long?=null,

    @ColumnInfo(name="date")
    var date: String, //yyyy-MM-dd

    @ColumnInfo(name="content")
    var content: String,

    @ColumnInfo(name="check")
    var isChecked: Boolean=false
): Serializable