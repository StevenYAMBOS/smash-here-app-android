package com.stevenyambos.smashhereapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stevenyambos.smashhereapp.screens.AdvancedTechniquesFragment
import com.stevenyambos.smashhereapp.screens.HomeFragment
import com.stevenyambos.smashhereapp.screens.SettingsFragment
import java.util.*
import kotlin.collections.ArrayList

/* Faire attention lors des import car il y a des éléments "androidx" avec le même nom que d'autres
 éléments, choisir celui approprié. */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Fragments des écrans
        val homeFragment = HomeFragment()
        val advancedTechniquesFragment = AdvancedTechniquesFragment()
        val settingsFragment = SettingsFragment()

        // Écran principal
        setCurrentFragment(homeFragment)

        // Instantiation de la bottom navigation view
        val botttom_navigation_bar : BottomNavigationView = findViewById(R.id.bottom_navigation_bar)

        // Bottom Nav View
        botttom_navigation_bar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_item_home -> {
                    setCurrentFragment(homeFragment)
                }
                R.id.nav_item_advanced_techniques -> {
                    setCurrentFragment(advancedTechniquesFragment)
                }
                R.id.nav_item_settings -> {
                    setCurrentFragment(settingsFragment)
                }
            }
            true
        }
    } // Fin onCreate

    // Le fragment manager gère les fragments
     private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout, fragment)
            commit()
        }
    }

} // fin MainActivity