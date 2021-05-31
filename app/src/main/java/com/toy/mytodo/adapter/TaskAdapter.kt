package com.toy.mytodo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.toy.mytodo.databinding.ItemTaskBinding
import com.toy.mytodo.repository.dto.Task

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    private lateinit var binding: ItemTaskBinding
    private var tasks=listOf<Task>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding= ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    fun setTasks(tasks: List<Task>){
        this.tasks=tasks
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(task: Task){
            binding.task=task
            binding.executePendingBindings() // 데이터가 수정되면 즉각 바인딩
        }
    }

    companion object TaskDiffUtil: DiffUtil.ItemCallback<Task>(){
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem==newItem
        }
    }
}