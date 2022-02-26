package com.seif.hospitalsystem.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seif.hospitalsystem.data.models.Case
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.databinding.FragmentCasesBinding
import com.seif.hospitalsystem.ui.CasesAdapter


class CasesFragment : Fragment() {
    lateinit var binding:FragmentCasesBinding
    val casesAdapter by lazy { CasesAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCasesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        casesAdapter.addCases(createDummyCases())
        binding.rvCases.adapter = casesAdapter
    }
    private fun createDummyCases():List<Case>{
        return listOf<Case>(
            Case(
               1,
               "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Pending,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                2,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Pending,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                3,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Pending,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                4,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Pending,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                5,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Pending,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                6,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Pending,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                7,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Pending,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
        )
    }

}