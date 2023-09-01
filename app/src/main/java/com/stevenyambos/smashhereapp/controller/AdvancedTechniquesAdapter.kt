package com.stevenyambos.smashhereapp.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.stevenyambos.smashhereapp.R
import com.stevenyambos.smashhereapp.model.AdvancedTechniquesModel


class AdvancedTechniquesAdapter(private var ATsList : List<AdvancedTechniquesModel>) : RecyclerView.Adapter<AdvancedTechniquesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.advanced_techniques_model, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val currentItem = ATsList[position]
        holder.ATsImage.setImageResource(currentItem.gif)
        holder.ATsText.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return ATsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ATsImage: ImageView = itemView.findViewById(R.id.image_ATs_model)
        val ATsText: TextView = itemView.findViewById(R.id.text_ATs_model)
    }

}