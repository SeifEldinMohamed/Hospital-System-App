package com.seif.hospitalsystem.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        activity?.window?.statusBarColor = requireActivity().getColor(R.color.mediumGreen)
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarProfile.setNavigationIcon(R.drawable.ic_arrow_back_white)
        binding.toolbarProfile.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        activity?.window?.statusBarColor = requireActivity().getColor(R.color.white)
    }
}