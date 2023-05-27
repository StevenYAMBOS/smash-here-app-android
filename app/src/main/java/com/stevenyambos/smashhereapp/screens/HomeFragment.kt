package com.stevenyambos.smashhereapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stevenyambos.smashhereapp.R
import com.stevenyambos.smashhereapp.reyclerview.AdvancedTechniquesList
import com.stevenyambos.smashhereapp.reyclerview.AdvancedTechniquesListAdapter

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}