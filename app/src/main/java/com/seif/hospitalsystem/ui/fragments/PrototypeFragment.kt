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
import com.seif.hospitalsystem.databinding.FragmentPrototypeBinding


class PrototypeFragment : Fragment() {
lateinit var binding: FragmentPrototypeBinding
lateinit var pref: SharedPreferences
lateinit var edit: SharedPreferences.Editor
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
        pref = requireContext().getSharedPreferences("specialist", Context.MODE_PRIVATE)
        edit = pref.edit()
        binding.btnDoctor.setOnClickListener {
            edit.putString("Spec","Doctor")
            edit.apply()
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnAnalysisEmployee.setOnClickListener {
            edit.putString("Spec","Analysis employee")
            edit.apply()
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnReceptionist.setOnClickListener {
            edit.putString("Spec","Receptionist")
            edit.apply()
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)


        }
        binding.btnNurse.setOnClickListener {
            edit.putString("Spec","Nurse")
            edit.apply()
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)


        }
        binding.btnManager.setOnClickListener {
            edit.putString("Spec","Manager")
            edit.apply()
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)


        }
        binding.btnHr.setOnClickListener {
            edit.putString("Spec","HR")
            edit.apply()
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
    }

}