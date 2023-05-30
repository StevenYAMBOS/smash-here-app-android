package com.stevenyambos.smashhereapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stevenyambos.smashhereapp.R

class SettingsScreen : AppCompatActivity() {
    private lateinit var toolbar_settingsScreen : Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings_screen)

        toolbar_settingsScreen = findViewById(R.id.toolbar_SettingsScreen)
        setSupportActionBar(toolbar_settingsScreen)
        supportActionBar?.apply {
            // va naviguer vers l'Activité parente
            setDisplayHomeAsUpEnabled(true) // affiche le bouton de retour
            setDisplayShowTitleEnabled(false) // Supprime le titre de l'application
            setHomeAsUpIndicator(R.drawable.arrow_back) // Mettre le boutton de retour en blanc
        }



    } // Fin onCreate

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    // Navigation avec le bouton Android
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}