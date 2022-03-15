package com.seif.hospitalsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.data.models.MyNotification
import com.seif.hospitalsystem.databinding.FragmentNotificationBinding
import com.seif.hospitalsystem.ui.adapters.NotificationAdapter


class NotificationFragment : Fragment() {
    lateinit var binding: FragmentNotificationBinding
    private val notificationAdapter by lazy { NotificationAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarNotification.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarNotification.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        notificationAdapter.addNotifications(createDummyNotifications())
        binding.rvNotification.adapter = notificationAdapter

    }

    private fun createDummyNotifications(): List<MyNotification> {
        return listOf(
            MyNotification(
                1,
                "Seif Mohamed",
                "You have new call from manger",
                "02:39AM",
                R.drawable.seif_image
            ),
            MyNotification(
                2,
                "Seif Mohamed",
                "You have new call from manger",
                "02:39AM",
                R.drawable.seif_image
            ),
            MyNotification(
                3,
                "Seif Mohamed",
                "You have new call from manger",
                "02:39AM",
                R.drawable.seif_image
            ),
            MyNotification(
                4,
                "Seif Mohamed",
                "You have Medical record from analysis\n" + "employee",
                "02:39AM",
                R.drawable.seif_image
            ),
            MyNotification(
                5,
                "Seif Mohamed",
                "You have New Call from Receptionist",
                "02:39AM",
                R.drawable.seif_image
            ),
        )
    }
}