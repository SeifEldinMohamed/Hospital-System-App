package com.seif.hospitalsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.databinding.FragmentCheckAttendanceBinding


class CheckAttendanceFragment : Fragment() {
lateinit var binding: FragmentCheckAttendanceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        activity?.window?.statusBarColor = requireActivity().getColor(R.color.mediumGreen)
        binding = FragmentCheckAttendanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fingerPrintImg.setOnClickListener { // temporarily
            findNavController().navigate(R.id.action_checkAttendanceFragment_to_successfulFingerPrintFragment)
        }
    }

    override fun onStart() {
        super.onStart()
        activity?.window?.statusBarColor = requireActivity().getColor(R.color.mediumGreen)

    }

    override fun onStop() {
        super.onStop()
        activity?.window?.statusBarColor = requireActivity().getColor(R.color.white)
    }

}