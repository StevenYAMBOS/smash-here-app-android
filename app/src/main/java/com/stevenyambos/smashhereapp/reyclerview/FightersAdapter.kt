package com.stevenyambos.smashhereapp.reyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.stevenyambos.smashhereapp.R

class FightersAdapter(private var fightersList: ArrayList<FightersModel>):
RecyclerView.Adapter<FightersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fighterImage: ImageView = itemView.findViewById(R.id.image_fighter_model)
        val fighterName: TextView = itemView.findViewById(R.id.text_fighter_model)
    }

    fun setFilteredFightersList(fightersList: ArrayList<FightersModel>) {
        this.fightersList = fightersList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fighters_model,parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = fightersList[position]
        holder.fighterImage.setImageResource(currentItem.image)
        holder.fighterName.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return fightersList.size
    }

}
