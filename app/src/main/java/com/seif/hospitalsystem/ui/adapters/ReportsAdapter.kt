package com.seif.hospitalsystem.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.seif.hospitalsystem.data.models.Case
import com.seif.hospitalsystem.data.models.Report
import com.seif.hospitalsystem.data.models.Status
import com.seif.hospitalsystem.databinding.SendCasesItemRowBinding
import com.seif.hospitalsystem.ui.fragments.CasesFragmentDirections

class ReportsAdapter: RecyclerView.Adapter<ReportsAdapter.MyViewHolder>() {
    private var reports: List<Report> = emptyList()
    inner class MyViewHolder(private val binding: SendCasesItemRowBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int, reports: List<Report>){
            binding.txtPatientName.text = reports[position].name
            binding.txtDate.text = reports[position].date
            if(reports[position].status == Status.Finished){
                binding.imgStatusFinish.visibility = View.VISIBLE
                binding.imgStatusPending.visibility = View.GONE
            }
            else{ // in case of pending case
                binding.imgStatusFinish.visibility = View.GONE
                binding.imgStatusPending.visibility = View.VISIBLE
            }
            binding.cardCaseItemRow.setOnClickListener {
//                val action = CasesFragmentDirections.actionCasesFragmentToCaseDetailsFragment(reports[position])
//                itemView.findNavController().navigate(action)
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
        holder.bind(position, reports)
    }

    override fun getItemCount(): Int {
        return reports.size
    }
    fun addReports(reports: List<Report>){
        this.reports = reports
        // DiffUtil
    }
}