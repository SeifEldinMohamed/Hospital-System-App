package com.seif.hospitalsystem.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.databinding.FragmentCreateCallBinding


class CreateCallFragment : Fragment() {
lateinit var binding: FragmentCreateCallBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCreateCallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // handle navigation back up from toolbar
        binding.toolbarCreateCases.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarCreateCases.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.btnSendCall.setOnClickListener {
            findNavController().navigate(R.id.action_createCallFragment_to_selectFragment)
        }

    }

}