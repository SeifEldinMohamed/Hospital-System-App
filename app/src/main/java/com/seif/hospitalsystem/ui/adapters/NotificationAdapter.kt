package com.seif.hospitalsystem.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seif.hospitalsystem.data.models.MyNotification
import com.seif.hospitalsystem.databinding.NotificationItemRowBinding

class NotificationAdapter: RecyclerView.Adapter<NotificationAdapter.MyViewHolder>() {
      private var notifications = emptyList<MyNotification>()
   inner class MyViewHolder(private val binding: NotificationItemRowBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int, notifications:List<MyNotification>){
                binding.senderImg.setImageResource(notifications[position].senderImage)
                binding.txtNotificationSender.text = notifications[position].senderName
                binding.txtNotificationBody.text = notifications[position].notificationBody
                binding.txtNotificationTime.text = notifications[position].time
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            NotificationItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.bind(position, notifications)
    }

    override fun getItemCount(): Int {
        return notifications.size
    }

    fun addNotifications(notifications: List<MyNotification>){
        this.notifications = notifications
        notifyDataSetChanged()
    }
}