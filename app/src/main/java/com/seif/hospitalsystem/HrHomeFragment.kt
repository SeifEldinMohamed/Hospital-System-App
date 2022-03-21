package com.seif.hospitalsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.databinding.FragmentHrHomeBinding


class HrHomeFragment : Fragment() {
lateinit var binding: FragmentHrHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHrHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardAttendanceHr.setOnClickListener {
            findNavController().navigate(R.id.action_hrHomeFragment_to_attendanceFragment2)
        }
        binding.cardReportsHr.setOnClickListener {
            findNavController().navigate(R.id.action_hrHomeFragment_to_reportsFragment2)
        }
        binding.cardTasksHr.setOnClickListener {
            findNavController().navigate(R.id.action_hrHomeFragment_to_tasksFragment2)
        }

    }

}