package com.seif.hospitalsystem.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.data.sharedPreference.AppSharedPreference
import com.seif.hospitalsystem.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AppSharedPreference.init(requireContext())

       val specialization = AppSharedPreference.readSpecialization("Spec", "")
        handleDesignSignIn(specialization)

        binding.profileImg.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
        binding.txtProfileName.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
        binding.cardCalls.setOnClickListener {
            when (specialization){
                "Receptionist" -> {
                    findNavController().navigate(R.id.action_homeFragment_to_casesFragment)
                }
            }
        }
        binding.cardReports.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_reportsFragment)
        }
        binding.cardTasks.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_tasksFragment)
        }
        binding.cardAttendance.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_attendanceFragment)
        }
        binding.imgNotification.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_notificationFragment)
        }
    }

    private fun handleDesignSignIn(specialization: String){
        binding.txtSpecialist.text = "Specialist, $specialization"
        when(specialization){
            "Receptionist" ->{
                binding.cardCases.visibility = View.GONE
                binding.imageCalls.setImageResource(R.drawable.ic_calls)
                binding.txtCalls.text = getString(R.string.calls)
                Log.d("home", specialization)
            }
            "Doctor" , "Nurse" -> {
                binding.cardCases.visibility = View.VISIBLE
                binding.imageCalls.setImageResource(R.drawable.ic_calls)
                binding.txtCalls.text = getString(R.string.calls)
                Log.d("home", specialization)
            }
            "HR" -> {
                binding.cardCases.visibility = View.GONE
                binding.imageCalls.setImageResource(R.drawable.ic_employee)
                binding.txtCalls.text = getString(R.string.employee)
                Log.d("home", specialization)
            }
            "Manager" -> {
                binding.cardCases.visibility = View.VISIBLE
                binding.imageCalls.setImageResource(R.drawable.ic_employee)
                binding.txtCalls.text = getString(R.string.employee)
                Log.d("home", specialization)
            }
            else -> {
                binding.cardCases.visibility = View.GONE
                binding.imageCalls.setImageResource(R.drawable.ic_cases)
                binding.txtCalls.text = getString(R.string.cases)
                Log.d("home", specialization)
            }
        }
    }
}