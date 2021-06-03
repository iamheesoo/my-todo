package com.toy.mytodo.util

import android.util.Log
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.toy.mytodo.adapter.TaskAdapter
import com.toy.mytodo.repository.dto.Task

object DatabindingUtils {

    private val TAG="DatabindingUtils"

    @BindingAdapter("bind_checkbox")
    @JvmStatic
    fun bindCheckbox(checkBox: AppCompatCheckBox, isChecked: Boolean){
        checkBox.isChecked=isChecked
    }

}