package com.seif.hospitalsystem.ui.fragments

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.data.models.Report
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.databinding.FragmentReportsBinding
import com.seif.hospitalsystem.ui.adapters.ReportsAdapter
import java.util.*


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

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarReports.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarReports.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        reportsAdapter.addReports(createDummyReports())
        binding.rvReports.adapter = reportsAdapter

        val calender = Calendar.getInstance()
//        val dataPicker: DatePickerDialog.OnDateSetListener =
//            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
//                calender.set(Calendar.YEAR, year)
//                calender.set(Calendar.MONTH, month)
//                calender.set(Calendar.DAY_OF_MONTH, day)
//                updateLabel(calender)
//            }
        binding.calendarEditTextReport.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(
                requireContext(),
                R.style.BottomSheetDialogTheme
            )
            val bottomSheetView = LayoutInflater.from(requireContext()).inflate(
                R.layout.buttomsheet_layout,
                view.findViewById<ConstraintLayout>(R.id.buttom_sheet)
            )
            bottomSheetView.findViewById<CalendarView>(R.id.calendarView)
                ?.setOnDateChangeListener { view, year, month, dayOfMonth ->
                    calender.set(Calendar.YEAR, year)
                    calender.set(Calendar.MONTH, month)
                    calender.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    updateLabel(calender)
                    bottomSheetDialog.dismiss()
                }
            bottomSheetDialog.setContentView(bottomSheetView)
            bottomSheetDialog.show()
        }
        binding.btnAddReport.setOnClickListener {
            findNavController().navigate(R.id.action_reportsFragment_to_createReportFragment)
        }

    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateLabel(calender: Calendar) {
        val sdf = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val format = "dd-MM-yyyy"
            SimpleDateFormat(format, Locale.UK)
        }
        else { // check it again //////////////////////////////////////////////////////
            val format = "dd-MM-yyyy"
            SimpleDateFormat(format, Locale.UK)
        }
        binding.calendarEditTextReport.setText(sdf.format(calender.time))
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