package com.toy.mytodo.util

import androidx.appcompat.widget.AppCompatCheckBox
import androidx.databinding.BindingAdapter

object DatabindingUtils {
    @BindingAdapter("bind_checkbox")
    @JvmStatic
    fun bindCheckbox(checkBox: AppCompatCheckBox, isChecked: Boolean){
        checkBox.isChecked=isChecked
    }


}