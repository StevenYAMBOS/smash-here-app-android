package com.stevenyambos.smashhereapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.stevenyambos.smashhereapp.R
import com.stevenyambos.smashhereapp.screens.settings.AboutScreen
import com.stevenyambos.smashhereapp.screens.settings.LanguagesSceen
import com.stevenyambos.smashhereapp.screens.settings.ThemesScreen

class SettingsScreen : AppCompatActivity() {
    private lateinit var toolbar_settingsScreen : Toolbar
    private lateinit var languagesScreenButton: CardView
    private lateinit var themesScreenButton: CardView
    private lateinit var aboutScreenButton: CardView
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


        languagesScreenButton = findViewById(R.id.cardview_languages)
        themesScreenButton = findViewById(R.id.cardview_themes)
        aboutScreenButton = findViewById(R.id.cardview_about)

        languagesScreenButton.setOnClickListener {
            val intent = Intent(this, LanguagesSceen::class.java)
            startActivity(intent)
        }
        themesScreenButton.setOnClickListener {
            val intent = Intent(this, ThemesScreen::class.java)
            startActivity(intent)
        }
        aboutScreenButton.setOnClickListener {
            val intent = Intent(this, AboutScreen::class.java)
            startActivity(intent)
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