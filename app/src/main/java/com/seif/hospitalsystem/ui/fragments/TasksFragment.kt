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
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.data.models.Task
import com.seif.hospitalsystem.databinding.FragmentTasksBinding
import com.seif.hospitalsystem.ui.adapters.TasksAdapter
import java.util.*


class TasksFragment : Fragment() {
lateinit var binding: FragmentTasksBinding
val taskAdapter by lazy { TasksAdapter() }
   lateinit var todoList : List<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarTasks.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarTasks.setNavigationOnClickListener {
            findNavController().navigateUp()
            // requireActivity().onBackPressed()
        }

        todoList = generateDummyList()
        taskAdapter.addTasks(createDummyTasks())
        binding.rvTasks.adapter = taskAdapter

        val calender = Calendar.getInstance()
//        val dataPicker: DatePickerDialog.OnDateSetListener =
//            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
//                calender.set(Calendar.YEAR, year)
//                calender.set(Calendar.MONTH, month)
//                calender.set(Calendar.DAY_OF_MONTH, day)
//                updateLabel(calender)
//            }
        binding.calendarEditTextTasks.setOnClickListener {
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
        binding.calendarEditTextTasks.setText(sdf.format(calender.time))
    }

    private fun generateDummyList(): List<String> {
        return  listOf(
            "task1",
            "task2",
            "task3",
            "task4",
            "task5"
        )
    }

    private fun createDummyTasks(): List<Task> {
        return listOf(
            Task(
                1,
                "task 1",
                Status.Finished,
                getString(R.string.lorem_case_description),
                "14.03.2022",
                todoList
            ),
            Task(
                2,
                "task 2",
                Status.Process,
                getString(R.string.lorem_case_description),
                "14.03.2022",
                todoList
            ),
            Task(
                3,
                "task 3",
                Status.Finished,
                getString(R.string.lorem_case_description),
                "14.03.2022",
                todoList
            ),
            Task(
                4,
                "task 4",
                Status.Process,
                getString(R.string.lorem_case_description),
                "14.03.2022",
                todoList
            ),
            Task(
                5,
                "task 5",
                Status.Finished,
                getString(R.string.lorem_case_description),
                "14.03.2022",
                todoList
            ),
            Task(
                6,
                "task 6",
                Status.Process,
                getString(R.string.lorem_case_description),
                "14.03.2022",
                todoList
            )
        )
    }

}