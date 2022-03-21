package com.seif.hospitalsystem.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.seif.hospitalsystem.HrActivity
import com.seif.hospitalsystem.ReceptionistActivity
import com.seif.hospitalsystem.data.sharedPreference.AppSharedPreference
import com.seif.hospitalsystem.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {
lateinit var binding: FragmentSignInBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener {
            when (AppSharedPreference.readSpecialization("Spec", "") ){
                "Receptionist" -> startActivity(Intent(requireContext(), ReceptionistActivity::class.java))
//                "Doctor" -> startActivity(Intent(requireContext(), MainActivity::class.java))
//                "Analysis employee" -> startActivity(Intent(requireContext(), MainActivity::class.java))
//                "Nurse" -> startActivity(Intent(requireContext(), MainActivity::class.java))
//                "Manager" -> startActivity(Intent(requireContext(), MainActivity::class.java))
                "HR" -> startActivity(Intent(requireContext(), HrActivity::class.java))
                else -> {
                    Toast.makeText(requireContext(), "not finished yet !", Toast.LENGTH_SHORT).show()
                }
            }
            requireActivity().finish()
        }
    }
}