package com.seif.hospitalsystem.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.data.sharedPreference.AppSharedPreference
import com.seif.hospitalsystem.databinding.FragmentPrototypeBinding


class PrototypeFragment : Fragment() {
lateinit var binding: FragmentPrototypeBinding
//lateinit var pref: SharedPreferences
//lateinit var edit: SharedPreferences.Editor
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPrototypeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        AppSharedPreference.init(requireContext())
        binding.btnDoctor.setOnClickListener {
            AppSharedPreference.writeSpecialization("Spec","Doctor")
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnAnalysisEmployee.setOnClickListener {
            AppSharedPreference.writeSpecialization("Spec","Analysis employee")
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnReceptionist.setOnClickListener {
            AppSharedPreference.writeSpecialization("Spec","Receptionist")
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnNurse.setOnClickListener {
            AppSharedPreference.writeSpecialization("Spec","Nurse")
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnManager.setOnClickListener {
            AppSharedPreference.writeSpecialization("Spec","Manager")
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnHr.setOnClickListener {
            AppSharedPreference.writeSpecialization("Spec","HR")
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
    }

}