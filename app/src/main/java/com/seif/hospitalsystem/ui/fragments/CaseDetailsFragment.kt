package com.seif.hospitalsystem.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.seif.hospitalsystem.R
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.databinding.FragmentCaseDetailsBinding
import com.seif.hospitalsystem.ui.fragments.CaseDetailsFragmentArgs.fromBundle
class CaseDetailsFragment : Fragment() {
lateinit var binding: FragmentCaseDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCaseDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarCaseDescription.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbarCaseDescription.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
       val patientName = fromBundle(requireArguments()).case.patientName
       val patientAge = fromBundle(requireArguments()).case.patientAge
       val phoneNumber = fromBundle(requireArguments()).case.phoneNumber
       val caseStatus = fromBundle(requireArguments()).case.caseStatus
       val caseDescription = fromBundle(requireArguments()).case.caseDescription
       val date = fromBundle(requireArguments()).case.date

        binding.txtName.text = patientName
        binding.txtAge.text = "$patientAge Years"
        binding.txtPhoneNumber.text = phoneNumber
        binding.txtCaseDescription.text = caseDescription
        binding.txtStatus.text = caseStatus.toString()
        binding.txtDate.text = date

        if (caseStatus == Status.Process){
            binding.txtStatus.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_pending, 0)
            binding.txtStatus.text = getString(R.string.process)
            binding.btnLoggedOut.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
            binding.btnLoggedOut.text = getString(R.string.log_out)
        }
        else{
            binding.txtStatus.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_finish, 0)
            binding.txtStatus.text = getString(R.string.finished)
            binding.btnLoggedOut.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.mediumGray))
            binding.btnLoggedOut.text = getString(R.string.case_logged_out)
        }


        binding.btnLoggedOut.setOnClickListener {
            // update status of patient case and save it in the database then update ui
            binding.txtStatus.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_finish, 0)
            binding.txtStatus.text = getString(R.string.finished)
            binding.btnLoggedOut.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.mediumGray))
            binding.btnLoggedOut.text = getString(R.string.case_logged_out)
        }
    }
}