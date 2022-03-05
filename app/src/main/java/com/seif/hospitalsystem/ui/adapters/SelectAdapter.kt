package com.seif.hospitalsystem.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.data.models.User
import com.seif.hospitalsystem.data.models.UserStatus
import com.seif.hospitalsystem.databinding.SelectItemRowBinding

class SelectAdapter : RecyclerView.Adapter<SelectAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()

    inner class MyViewHolder(private val binding: SelectItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, userList: List<User>) {
            binding.txtUserName.text = "${userList[position].lastName} ${userList[position].lastName}"
            binding.txtSpecialistSelect.text = userList[position].specialist.toString()
            binding.userImg.setImageResource(userList[position].image)
            if (userList[position].userStatus == UserStatus.Online)
                binding.onlineStatusImg.setImageResource(R.drawable.ic_online_circle)
            else
                binding.onlineStatusImg.setImageResource(R.drawable.ic_offline_circle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SelectItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, userList)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun addUserList(userList: List<User>){
        this.userList = userList
        notifyDataSetChanged()
    }
}