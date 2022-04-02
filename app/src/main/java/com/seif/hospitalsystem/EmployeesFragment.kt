package com.seif.hospitalsystem

import android.graphics.drawable.GradientDrawable
import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seif.hospitalsystem.databinding.FragmentEmployeesBinding
import com.seif.hospitalsystem.ui.adapters.CategoryAdapter


class EmployeesFragment : Fragment() {
    lateinit var binding: FragmentEmployeesBinding
    private val categoryAdapter by lazy { CategoryAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentEmployeesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.addCategoryList(getCategoryList())
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategories.adapter = categoryAdapter

    }

    private fun getCategoryList(): List<String> {
        return listOf(
            "All",
            "Doctor",
            "Nurse",
            "HR Employee",
            "Analysis Employee",
        )
    }
}