package com.seif.hospitalsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seif.hospitalsystem.databinding.FragmentSelectBinding

class SelectFragment : Fragment() {
lateinit var binding: FragmentSelectBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSelectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarSelect.setNavigationIcon(R.drawable.ic_cancel)
        binding.toolbarSelect.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}