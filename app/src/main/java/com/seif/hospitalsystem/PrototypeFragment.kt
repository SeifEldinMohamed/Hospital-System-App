package com.seif.hospitalsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.seif.hospitalsystem.databinding.FragmentPrototypeBinding


class PrototypeFragment : Fragment() {
lateinit var binding: FragmentPrototypeBinding
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
        binding.btnDoctor.setOnClickListener {
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnAnalysisEmployee.setOnClickListener {
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnReceptionist.setOnClickListener {
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnNurse.setOnClickListener {
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnManager.setOnClickListener {
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
        binding.btnHr.setOnClickListener {
            findNavController().navigate(R.id.action_prototypeFragment2_to_signInFragment2)
        }
    }

}