package com.seif.hospitalsystem.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.databinding.FragmentCreateReportBinding


class CreateReportFragment : Fragment() {
lateinit var binding: FragmentCreateReportBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateReportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarCreateReport.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarCreateReport.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnCreateReport.setOnClickListener {
            requireActivity().onBackPressed()
            // logic to create report and send it to manager
        }
    }
}