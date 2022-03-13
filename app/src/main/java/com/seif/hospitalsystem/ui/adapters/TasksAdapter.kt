package com.seif.hospitalsystem.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.seif.hospitalsystem.TasksFragmentDirections
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.data.models.Task
import com.seif.hospitalsystem.databinding.TasksItemRowBinding


class TasksAdapter: RecyclerView.Adapter<TasksAdapter.MyViewHolder>() {
       private var tasks = emptyList<Task>()
   inner class MyViewHolder(val binding: TasksItemRowBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int, tasks: List<Task>){
                binding.txtTaskName.text = tasks[position].name
                binding.txtDateTask.text = tasks[position].date
                if(tasks[position].status == Status.Finished){
                    binding.txtProcessTask.visibility = View.GONE
                    binding.txtFinishedTask.visibility = View.VISIBLE
                }
                else{ // in case of pending case
                    binding.txtFinishedTask.visibility = View.GONE
                    binding.txtProcessTask.visibility = View.VISIBLE
                }
                binding.cardTaskItemRow.setOnClickListener {
                    val action = TasksFragmentDirections.actionTasksFragmentToTaskDetailsFragment(tasks[position])
                    itemView.findNavController().navigate(action)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TasksItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, tasks)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }
    fun addTasks(newTasks: List<Task>){
        this.tasks = newTasks
        notifyDataSetChanged()
    }

}