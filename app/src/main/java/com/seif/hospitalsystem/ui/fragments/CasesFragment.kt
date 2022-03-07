package com.seif.hospitalsystem.ui.fragments

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.data.models.Case
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.databinding.FragmentCasesBinding
import com.seif.hospitalsystem.ui.adapters.CasesAdapter
import java.util.*


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

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // set up recycler view
        casesAdapter.addCases(createDummyCases())
        binding.rvCases.adapter = casesAdapter
        // handle navigation back up from toolbar
        binding.toolbarCases.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarCases.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }

        val calender = Calendar.getInstance()
//        val dataPicker: DatePickerDialog.OnDateSetListener =
//            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
//                calender.set(Calendar.YEAR, year)
//                calender.set(Calendar.MONTH, month)
//                calender.set(Calendar.DAY_OF_MONTH, day)
//                updateLabel(calender)
//            }
        binding.calendarEditText.setOnClickListener {
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
        binding.btnAddCase.setOnClickListener {
            findNavController().navigate(R.id.action_casesFragment_to_createCallFragment)
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
        binding.calendarEditText.setText(sdf.format(calender.time))
    }
    private fun createDummyCases():List<Case>{
        return listOf<Case>(
            Case(
               1,
               "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Process,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                2,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Process,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                3,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Process,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                4,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Process,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                5,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Process,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                6,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Process,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
            Case(
                7,
                "Seif Mohamed",
                20,
                "01000883795",
                "26.02.2022",
                Status.Process,
                "Cook aromatic turkey in a frying pan with vinegar for about an hour to chamfer their sweetness." ,
                "Mohamed"
            ),
        )
    }

}