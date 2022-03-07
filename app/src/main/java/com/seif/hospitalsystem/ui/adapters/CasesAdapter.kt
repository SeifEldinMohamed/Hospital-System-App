package com.seif.hospitalsystem.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.seif.hospitalsystem.data.models.Case
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.databinding.SendCasesItemRowBinding
import com.seif.hospitalsystem.ui.fragments.CasesFragmentDirections

class CasesAdapter: RecyclerView.Adapter<CasesAdapter.MyViewHolder>() {
    private var cases: List<Case> = emptyList()
    inner class MyViewHolder(private val binding:SendCasesItemRowBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(position: Int, cases: List<Case>){
                binding.txtPatientName.text = cases[position].patientName
                binding.txtDate.text = cases[position].date
                if(cases[position].caseStatus == Status.Finished){
                    binding.imgStatusFinish.visibility = View.VISIBLE
                    binding.imgStatusPending.visibility = View.GONE
                }
                else{ // in case of pending case
                    binding.imgStatusFinish.visibility = View.GONE
                    binding.imgStatusPending.visibility = View.VISIBLE
                }
                binding.cardCaseItemRow.setOnClickListener {
                        val action = CasesFragmentDirections.actionCasesFragmentToCaseDetailsFragment(cases[position])
                        itemView.findNavController().navigate(action)
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SendCasesItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, cases)
    }

    override fun getItemCount(): Int {
        return cases.size
    }
    fun addCases(cases: List<Case>){
        this.cases = cases
    }
}