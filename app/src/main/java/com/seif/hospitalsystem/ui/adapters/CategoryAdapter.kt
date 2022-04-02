package com.seif.hospitalsystem.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.seif.hospitalsystem.databinding.CategoriesItemRowBinding

class CategoryAdapter(): RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {
    private var categoryList = emptyList<String>()
    class MyViewHolder(private val binding: CategoriesItemRowBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(position: Int, categoryList:List<String>){
                binding.txtCategory.text = categoryList[position]
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CategoriesItemRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
                )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position, categoryList)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    fun addCategoryList(categoryList:List<String>){
        this.categoryList = categoryList
        notifyDataSetChanged()
    }

}