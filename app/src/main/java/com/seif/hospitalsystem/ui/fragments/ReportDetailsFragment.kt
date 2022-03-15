package com.seif.hospitalsystem.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.databinding.FragmentReportDetailsBinding


class ReportDetailsFragment : Fragment() {
lateinit var binding: FragmentReportDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReportDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarReportDetails.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarReportDetails.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

    }
}