package com.stevenyambos.smashhereapp.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stevenyambos.smashhereapp.R
import com.stevenyambos.smashhereapp.controller.FightersAdapter
import com.stevenyambos.smashhereapp.model.FightersModel

/* Faire attention lors des import car il y a des éléments "androidx" avec le même nom que d'autres
 éléments, choisir celui approprié. */
class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeScreen = FightersFragment()
        val advancedTechniquesScreen = AdvancedTechniquesFragment()
        val settingsScreen = SettingsFragment()

        setCurrentFragment(homeScreen)

        // Instantiation de la bottom navigation view
        val botttom_navigation_bar : BottomNavigationView = findViewById(R.id.bottom_navigation_bar)

        // Bottom Nav View
        botttom_navigation_bar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_item_home -> setCurrentFragment(homeScreen)
                R.id.nav_item_advanced_techniques -> setCurrentFragment(advancedTechniquesScreen)
                R.id.nav_item_settings -> setCurrentFragment(settingsScreen)
            }
            true
        }

    } // Fin onCreate

private fun setCurrentFragment(fragment: Fragment) =
    supportFragmentManager.beginTransaction().apply {
        replace(R.id.framelayout_activityMain,fragment)
        commit()
    }

}// fin MainActivity