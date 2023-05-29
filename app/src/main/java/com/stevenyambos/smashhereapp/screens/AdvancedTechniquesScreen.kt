package com.stevenyambos.smashhereapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stevenyambos.smashhereapp.R

class AdvancedTechniquesScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_techniques_screen)

        // Instantiation de la bottom navigation view
        val botttom_navigation_bar : BottomNavigationView = findViewById(R.id.bottomNavigationBar_ATsScreen)

        // Bottom Nav View
        botttom_navigation_bar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_item_home -> {
                    startActivity(Intent(this, HomeScreen::class.java))
                    true
                }
                R.id.nav_item_advanced_techniques -> {
                    startActivity(Intent(this, AdvancedTechniquesScreen::class.java))
                    true
                }
                R.id.nav_item_settings -> {
                    startActivity(Intent(this, SettingsScreen::class.java))
                    true
                }
            }
            true
        }
    } // Fin onCreate
}