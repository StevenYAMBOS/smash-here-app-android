package com.stevenyambos.smashhereapp.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stevenyambos.smashhereapp.R
import com.stevenyambos.smashhereapp.reyclerview.AdvancedTechniquesList
import com.stevenyambos.smashhereapp.reyclerview.AdvancedTechniquesListAdapter


class AdvancedTechniquesFragment : Fragment() {

    private lateinit var adapter : AdvancedTechniquesListAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var AdvancedTechniquesList : ArrayList<AdvancedTechniquesList>

    lateinit var ATsImageID : Array<Int>
    lateinit var ATsTitle : Array<String>
    lateinit var ATsList : Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advanced_techniques, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView_ATs)
        recyclerView.layoutManager = layoutManager // Le recyclerview est un linear layout
        recyclerView.setHasFixedSize(true)
        adapter = AdvancedTechniquesListAdapter(AdvancedTechniquesList)
        recyclerView.adapter = adapter // Attribution de l'adaptateur à la vue
    // (un adapteur est toujours associé à une vue, je crois)
    }

    private fun dataInitialize() {
        AdvancedTechniquesList = arrayListOf<AdvancedTechniquesList>()

        ATsImageID = arrayOf(
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
        )

        ATsTitle = arrayOf(
            getString(R.string.b_reverse),
            getString(R.string.b_reverse),
            getString(R.string.b_reverse),
            getString(R.string.b_reverse),
            getString(R.string.b_reverse),
            getString(R.string.b_reverse),
            getString(R.string.b_reverse),
            getString(R.string.b_reverse),
            getString(R.string.b_reverse),
            getString(R.string.b_reverse)
        )

        for (i in ATsImageID.indices) {
            val at = AdvancedTechniquesList(ATsImageID[i], ATsTitle[i])
            AdvancedTechniquesList.add(at)
        }
    }

}