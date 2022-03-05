package com.seif.hospitalsystem.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.data.models.*
import com.seif.hospitalsystem.databinding.FragmentSelectBinding
import com.seif.hospitalsystem.ui.adapters.SelectAdapter

class SelectFragment : Fragment() {
private lateinit var binding: FragmentSelectBinding
private val adapter by lazy { SelectAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarSelect.setNavigationIcon(R.drawable.ic_cancel)
        binding.toolbarSelect.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        adapter.addUserList(dummyDoctorsData())
        binding.rvSelect.adapter = adapter

        binding.btnSelect.setOnClickListener {

        }

    }
    private fun dummyDoctorsData(): List<User>{
        return listOf<User>(
            User(
                1,
                UserStatus.Online,
                "Seif Eldin",
                "Mohamed",
                R.drawable.seif_image,
                Gender.Male,
                Specialist.Doctor,
                MaritalStatus.Single,
                "26 - 6 - 2001",
                "010000883795",
                "seifeldinmohamed101@gmail.com",
                "Cairo - Egypt",
                "123456"
            ),
            User(
                2,
                UserStatus.Online,
                "Hazem",
                "Khaled",
                R.drawable.seif_image,
                Gender.Male,
                Specialist.Doctor,
                MaritalStatus.Married,
                "26 - 1 - 2001",
                "010000883795",
                "seifeldinmohamed101@gmail.com",
                "Cairo - Egypt",
                "123456"
            ),
            User(
                3,
                UserStatus.Online,
                "Karem",
                "Galal",
                R.drawable.seif_image,
                Gender.Male,
                Specialist.Doctor,
                MaritalStatus.Divorced,
                "26 - 1 - 2004",
                "010000883795",
                "seifeldinmohamed101@gmail.com",
                "Cairo - Egypt",
                "123456"
            ),
            User(
                4,
                UserStatus.Online,
                "Mohamed",
                "Ahmed",
                R.drawable.seif_image,
                Gender.Male,
                Specialist.Doctor,
                MaritalStatus.Widowed,
                "26 - 1 - 2004",
                "010000883795",
                "seifeldinmohamed101@gmail.com",
                "Cairo - Egypt",
                "123456"
            ),
        User(
            5,
            UserStatus.Online,
            "Norhan",
            "Mohamed",
            R.drawable.seif_image,
            Gender.Male,
            Specialist.Doctor,
            MaritalStatus.Single,
            "26 - 1 - 2004",
            "010000883795",
            "seifeldinmohamed101@gmail.com",
            "Cairo - Egypt",
            "123456"
        )
        )
    }
}