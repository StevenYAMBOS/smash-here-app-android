package com.stevenyambos.smashhereapp.screens

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.stevenyambos.smashhereapp.R


class AdvancedTechniquesDetailedScreen : Fragment() {

    private lateinit var toolbar_ATs_Detailed_Screen: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true) // Permet d'indiquer qu'on souhaite utiliser le menu où contient le
        // bouton de retour dans la toolbar
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_advanced_techniques_detailed_screen, container, false)
        toolbar_ATs_Detailed_Screen = view.findViewById(R.id.toolbar_ats_detailed_screen)
        (activity as AppCompatActivity).setSupportActionBar(toolbar_ATs_Detailed_Screen)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        return view
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed() // Retourne au fragment précédent lorsque le bouton de retour est cliqué
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}