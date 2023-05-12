package com.stevenyambos.smashhereapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stevenyambos.smashhereapp.screens.AdvancedTechniquesFragment
import com.stevenyambos.smashhereapp.screens.HomeFragment
import com.stevenyambos.smashhereapp.screens.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val advancedTechniquesFragment = AdvancedTechniquesFragment()
        val settingsFragment = SettingsFragment()

        // Écran principal
        setCurrentFragment(homeFragment)

        val botttom_navigation_bar : BottomNavigationView = findViewById(R.id.bottom_navigation_bar)


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

    fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout, fragment)
            commit()
        }
    }
} // fin MainActivity