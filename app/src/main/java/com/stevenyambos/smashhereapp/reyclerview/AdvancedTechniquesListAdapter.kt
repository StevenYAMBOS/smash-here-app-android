package com.stevenyambos.smashhereapp.reyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.stevenyambos.smashhereapp.R
import com.stevenyambos.smashhereapp.screens.AdvancedTechniquesDetailedScreen

class AdvancedTechniquesListAdapter(private val ATsList: ArrayList<AdvancedTechniquesList>):
    RecyclerView.Adapter<AdvancedTechniquesListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.ats_item,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val currentItem = ATsList[position]
        holder.ATsimage.setImageResource(currentItem.ATsImage)
        holder.ATstitle.text = currentItem.ATsTitle
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                    val activity = view!!.context as AppCompatActivity
                    val AdvancedTechniquesDetailedScreen = AdvancedTechniquesDetailedScreen()
                    activity.supportFragmentManager.beginTransaction()
                        .replace(R.id.framelayout, AdvancedTechniquesDetailedScreen)
                        .addToBackStack(null).commit()
            }
        })
    }

    override fun getItemCount(): Int {
        return ATsList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val ATsimage : ImageView = itemView.findViewById(R.id.advancedTechniques_cardView_image)
    val ATstitle : TextView = itemView.findViewById(R.id.advancedTechniques_cardView_title)
    }
}