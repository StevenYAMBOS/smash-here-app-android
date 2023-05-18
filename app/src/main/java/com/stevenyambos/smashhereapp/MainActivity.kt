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

    private lateinit var  recyclerView : RecyclerView
    private lateinit var searchView: androidx.appcompat.widget.SearchView
    private var characterList = ArrayList<FightersList>()
    private lateinit var adapter : FightersListAdapter

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

        recyclerView = findViewById(R.id.reyclerview_fighters) // Instantiation
        searchView = findViewById(R.id.searchview_fighters) // Instantiation
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this) // Le recyclerview est un
        // linear layout
        adapter = FightersListAdapter(characterList) // Instantiation
        recyclerView.adapter = adapter // Attribution de l'adaptateur à la vue
        // (un adapteur est toujours associé à une vue, je crois)
        addDataToList()

        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })

    } // Fin onCreate

    // Le fragment manager gère les fragments
     private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout, fragment)
            commit()
        }
    }

    private fun filterList(query : String?){
        if (query != null){
            val filteredList = ArrayList<FightersList>()
            // character aurait s'appeler 'i', c'est juste pour que tu comprennes ce code plus tard
            for (i in characterList) {
                if (i.name.lowercase(Locale.ROOT).contains(query.lowercase(Locale.ROOT))){
                    filteredList.add(i)
                }
            }
            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Smash Bros character found",
                    Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    // Création des card des personnages de manière programmatique (passer par le XML alourdie l'app)
    private fun addDataToList() {
        characterList.add(FightersList("Alph", R.drawable.alph))
        characterList.add(FightersList("Banjo", R.drawable.banjo))
        characterList.add(FightersList("Bayonetta", R.drawable.bayonetta))
        characterList.add(FightersList("Bowser", R.drawable.bowser))
        characterList.add(FightersList("Bowser.Jr", R.drawable.bowser_jr))
        characterList.add(FightersList("Byleth", R.drawable.byleth))
        characterList.add(FightersList("Captain Falcon", R.drawable.captain_falcon))
        characterList.add(FightersList("Charizard", R.drawable.charizard))
        characterList.add(FightersList("Chrom", R.drawable.chrom))
        characterList.add(FightersList("Cloud", R.drawable.cloud))
        characterList.add(FightersList("Corrin", R.drawable.corrin))
        characterList.add(FightersList("Daisy", R.drawable.daisy))
        characterList.add(FightersList("Dark Pit", R.drawable.dark_pit))
        characterList.add(FightersList("Dark Samus", R.drawable.dark_samus))
        characterList.add(FightersList("Diddy Kong", R.drawable.diddy_kong))
        characterList.add(FightersList("Donkey Kong", R.drawable.donkey_kong))
        characterList.add(FightersList("Dr.Mario", R.drawable.dr_mario))
        characterList.add(FightersList("Falco", R.drawable.falco))
        characterList.add(FightersList("Fox", R.drawable.fox))
        characterList.add(FightersList("Ganondorf", R.drawable.ganondorf))
        characterList.add(FightersList("Greninja", R.drawable.greninja))
        characterList.add(FightersList("Hero", R.drawable.hero))
        characterList.add(FightersList("Ice Climbers", R.drawable.ice_climbers))
        characterList.add(FightersList("Ike", R.drawable.ike))
        characterList.add(FightersList("Incineroar", R.drawable.incineroar))
        characterList.add(FightersList("Inkling", R.drawable.inkling))
        characterList.add(FightersList("Isabelle", R.drawable.isabelle))
        characterList.add(FightersList("Ivysaur", R.drawable.ivysaur))
        characterList.add(FightersList("Jigglypuff", R.drawable.jigglypuff))
        characterList.add(FightersList("Joker", R.drawable.joker))
        characterList.add(FightersList("Kazuya", R.drawable.kazuya))
        characterList.add(FightersList("Ken", R.drawable.ken))
        characterList.add(FightersList("King Dedede", R.drawable.king_dedede))
        characterList.add(FightersList("King K.Rool", R.drawable.king_krool))
        characterList.add(FightersList("Kirby", R.drawable.kirby))
        characterList.add(FightersList("Link", R.drawable.link))
        characterList.add(FightersList("Little Mac", R.drawable.little_mac))
        characterList.add(FightersList("Lucario", R.drawable.lucario))
        characterList.add(FightersList("Lucas", R.drawable.lucas))
        characterList.add(FightersList("Lucina", R.drawable.lucina))
        characterList.add(FightersList("Luigi", R.drawable.luigi))
        characterList.add(FightersList("Mario", R.drawable.mario))
        characterList.add(FightersList("Marth", R.drawable.marth))
        characterList.add(FightersList("Megaman", R.drawable.mega_man))
        characterList.add(FightersList("Meta Knight", R.drawable.meta_knight))
        characterList.add(FightersList("Mewtwo", R.drawable.mewtwo))
        characterList.add(FightersList("Mii Brawler", R.drawable.mii_brawler))
        characterList.add(FightersList("Mii Gunner", R.drawable.mii_gunner))
        characterList.add(FightersList("Mii Swordfighter", R.drawable.mii_swordfighter))
        characterList.add(FightersList("Minmin", R.drawable.min_min))
        characterList.add(FightersList("Mr.Game & Watch", R.drawable.mr_game_and_watch))
        characterList.add(FightersList("Mythra", R.drawable.mythra))
        characterList.add(FightersList("Ness", R.drawable.ness))
        characterList.add(FightersList("Olimar", R.drawable.olimar))
        characterList.add(FightersList("Pac-Man", R.drawable.pacman))
        characterList.add(FightersList("Palutena", R.drawable.palutena))
        characterList.add(FightersList("Peach", R.drawable.peach))
        characterList.add(FightersList("Pichu", R.drawable.pichu))
        characterList.add(FightersList("Pikachu", R.drawable.pikachu))
        characterList.add(FightersList("Piranha Plant", R.drawable.piranha_plant))
        characterList.add(FightersList("Pit", R.drawable.pit))
        characterList.add(FightersList("Pokemon Trainer", R.drawable.pokemon_trainer))
        characterList.add(FightersList("Pyra", R.drawable.pyra))
        characterList.add(FightersList("Richter", R.drawable.richter))
        characterList.add(FightersList("Ridley", R.drawable.ridley))
        characterList.add(FightersList("R.O.B", R.drawable.rob))
        characterList.add(FightersList("Robin", R.drawable.robin))
        characterList.add(FightersList("Rosalina & Luma", R.drawable.rosalina))
        characterList.add(FightersList("Roy", R.drawable.roy))
        characterList.add(FightersList("Ryu", R.drawable.ryu))
        characterList.add(FightersList("Samus", R.drawable.samus))
        characterList.add(FightersList("Sephiroth", R.drawable.sephiroth))
        characterList.add(FightersList("Sheik", R.drawable.sheik))
        characterList.add(FightersList("Shulk", R.drawable.shulk))
        characterList.add(FightersList("Simon", R.drawable.simon))
        characterList.add(FightersList("Snake", R.drawable.snake))
        characterList.add(FightersList("Sonic", R.drawable.sonic))
        characterList.add(FightersList("Sora", R.drawable.sora))
        characterList.add(FightersList("Daisy", R.drawable.daisy))
        characterList.add(FightersList("Squirtle", R.drawable.squirtle))
        characterList.add(FightersList("Steve", R.drawable.steve))
        characterList.add(FightersList("Terry", R.drawable.terry))
        characterList.add(FightersList("Toon Link", R.drawable.toon_link))
        characterList.add(FightersList("Villager", R.drawable.villager))
        characterList.add(FightersList("Wario", R.drawable.wario))
        characterList.add(FightersList("Wii Fit Trainer", R.drawable.wii_fit_trainer))
        characterList.add(FightersList("Wolf", R.drawable.wolf))
        characterList.add(FightersList("Yoshi", R.drawable.yoshi))
        characterList.add(FightersList("Young Link", R.drawable.young_link))
        characterList.add(FightersList("Zelda", R.drawable.zelda))
        characterList.add(FightersList("Zero Suit Samus", R.drawable.zero_suit_samus))
    }

} // fin MainActivity