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


//        Images des cardViews (initialisation)
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
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
            R.drawable.breverse,
        )

//        Textes des cardViews (initialisation)
        ATsTitle = arrayOf(
            getString(R.string.attack_cancel_short_hop_aerial),
            getString(R.string.b_reverse),
            getString(R.string.bat_droping),
            getString(R.string.boost_grab),
            getString(R.string.c_bouncing),
            getString(R.string.coil),
            getString(R.string.dash_cancel),
            getString(R.string.dash_dancing),
            getString(R.string.directional_influence),
            getString(R.string.drop_cancel),
            getString(R.string.edge_dashing),
            getString(R.string.edge_hoping),
            getString(R.string.fox_trotting),
            getString(R.string.hilldash),
            getString(R.string.jab_cancel),
            getString(R.string.jab_reset),
            getString(R.string.jump_cancel_throw),
            getString(R.string.jump_cancelling),
            getString(R.string.ledge_cancelling),
            getString(R.string.lock),
            getString(R.string.mindgame),
            getString(R.string.powershield),
            getString(R.string.reverse_aerial_rush),
            getString(R.string.shield_stop),
            getString(R.string.short_hop_air_airdodge),
            getString(R.string.slingshot),
            getString(R.string.smash_directional_influence),
            getString(R.string.stage_humping),
            getString(R.string.sticky_edge_jump),
            getString(R.string.taunt_cancelling),
            getString(R.string.teching),
            getString(R.string.tech_chasing),
            getString(R.string.wall_jump_cancel_ledge_grab),
            getString(R.string.wavedash),
            getString(R.string.waveland),
        )

        for (i in ATsImageID.indices) {
            val at = AdvancedTechniquesList(ATsImageID[i], ATsTitle[i])
            AdvancedTechniquesList.add(at)
        }
    }

//        Création des vues


}

