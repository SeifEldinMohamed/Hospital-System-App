package com.seif.hospitalsystem

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.seif.hospitalsystem.data.models.Report
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.databinding.FragmentReportsBinding
import com.seif.hospitalsystem.ui.adapters.ReportsAdapter


class ReportsFragment : Fragment() {
lateinit var binding: FragmentReportsBinding
private val reportsAdapter by lazy { ReportsAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentReportsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reportsAdapter.addReports(createDummyReports())
        binding.rvReports.adapter = reportsAdapter

    }

    private fun createDummyReports(): List<Report> {
        return listOf(
            Report(
                1,
                "Report 1",
                Status.Process,
                "Dark, misty woodchucks awkwardly break a cold, jolly landlubber.",
                0,
                "10.03.2022"
            ),
            Report(
                2,
                "Report 2",
                Status.Finished,
                "Dark, misty woodchucks awkwardly break a cold, jolly landlubber.",
                0,
                "10.04.2022"
            ),
            Report(
                3,
                "Report 3",
                Status.Process,
                "Dark, misty woodchucks awkwardly break a cold, jolly landlubber.",
                0,
                "10.03.2022"
            ),
            Report(
                4,
                "Report 4",
                Status.Finished,
                "Dark, misty woodchucks awkwardly break a cold, jolly landlubber.",
                0,
                "10.04.2022"
            ),
            Report(
                5,
                "Report 5",
                Status.Process,
                "Dark, misty woodchucks awkwardly break a cold, jolly landlubber.",
                0,
                "10.03.2022"
            ),
        )
    }
}