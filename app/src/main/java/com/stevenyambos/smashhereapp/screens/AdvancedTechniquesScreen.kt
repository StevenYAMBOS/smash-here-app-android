package com.stevenyambos.smashhereapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stevenyambos.smashhereapp.R
import com.stevenyambos.smashhereapp.controller.AdvancedTechniquesAdapter
import com.stevenyambos.smashhereapp.model.AdvancedTechniquesModel

class AdvancedTechniquesScreen : AppCompatActivity() {

    private lateinit var ATsrecyclerView: RecyclerView
    private lateinit var ATsList: ArrayList<AdvancedTechniquesModel>
    private lateinit var ATsAdapter: AdvancedTechniquesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_techniques_screen)

        // Instantiation de la bottom navigation view
        val botttom_navigation_bar: BottomNavigationView =
            findViewById(R.id.bottomNavigationBar_ATsScreen)

        // Bottom Nav View
        botttom_navigation_bar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_item_home -> {
                    startActivity(Intent(this, HomeScreen::class.java))
                    true
                }
                R.id.nav_item_settings -> {
                    startActivity(Intent(this, SettingsScreen::class.java))
                    true
                }
            }
            true
        }

        ATsrecyclerView = findViewById(R.id.recyclerView_ATsScreen)
        ATsrecyclerView.setHasFixedSize(true)
        ATsrecyclerView.layoutManager = LinearLayoutManager(this)
        ATsList = ArrayList()
        ATsAdapter = AdvancedTechniquesAdapter(ATsList)
        ATsrecyclerView.adapter = ATsAdapter
        ATsData()

    } // Fin onCreate

    private fun ATsData() {
        ATsList.add(
            AdvancedTechniquesModel(
                R.drawable.attack_cancel_short_hop_aerial,
                getString(R.string.attack_cancel_short_hop_aerial)
            )
        )
        ATsList.add(AdvancedTechniquesModel(R.drawable.breverse, getString(R.string.b_reverse)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.bat_droping, getString(R.string.bat_droping)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.boost_grab, getString(R.string.boost_grab)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.c_bouncing, getString(R.string.c_bouncing)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.coil, getString(R.string.coil)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.dash_cancel, getString(R.string.dash_cancel)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.dash_dancing, getString(R.string.dash_dancing)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.directional_influence, getString(R.string.directional_influence)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.drop_cancel, getString(R.string.drop_cancel)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.edge_dashing, getString(R.string.edge_dashing)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.edge_hopping, getString(R.string.edge_hopping)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.fox_trotting, getString(R.string.fox_trotting)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.hilldash, getString(R.string.hilldash)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.jab_cancel, getString(R.string.jab_cancel)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.jab_reset, getString(R.string.jab_reset)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.jump_cancel_throw, getString(R.string.jump_cancel_throw)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.jump_cancelling, getString(R.string.jump_cancelling)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.ledge_cancelling, getString(R.string.ledge_cancelling)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.lock, getString(R.string.lock)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.mindgame, getString(R.string.mindgame)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.powershield, getString(R.string.powershield)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.reverse_aerial_rush, getString(R.string.reverse_aerial_rush)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.shield_stop, getString(R.string.shield_stop)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.short_hop_air_airdodge, getString(R.string.short_hop_air_airdodge)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.slingshot, getString(R.string.slingshot)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.smash_directional_influence, getString(R.string.smash_directional_influence)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.stage_humping, getString(R.string.stage_humping)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.sticky_edge_jump, getString(R.string.sticky_edge_jump)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.taunt_cancelling, getString(R.string.taunt_cancelling)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.teching, getString(R.string.teching)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.tech_chasing, getString(R.string.tech_chasing)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.wall_jump_cancel_ledge_grab, getString(R.string.wall_jump_cancel_ledge_grab)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.wavedash, getString(R.string.wavedash)))
//        ATsList.add(AdvancedTechniquesModel(R.drawable.waveland, getString(R.string.waveland)))
    }
}
