package com.stevenyambos.smashhereapp.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stevenyambos.smashhereapp.R
import com.stevenyambos.smashhereapp.reyclerview.FightersAdapter
import com.stevenyambos.smashhereapp.reyclerview.FightersModel
import java.util.Locale

/* Faire attention lors des import car il y a des éléments "androidx" avec le même nom que d'autres
 éléments, choisir celui approprié. */

class HomeScreen : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fighterList: ArrayList<FightersModel>
    private lateinit var fightersAdapter: FightersAdapter
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiation de la bottom navigation view
        val botttom_navigation_bar : BottomNavigationView = findViewById(R.id.bottom_navigation_bar)

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

        recyclerView = findViewById(R.id.recyclerView_Fighters)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fighterList = ArrayList()
        fightersAdapter = FightersAdapter(fighterList)
        recyclerView.adapter = fightersAdapter
        searchView = findViewById(R.id.searchview_fighters)
        fighterListItem()

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterFightersList(newText)
                return true
            }

        })

    } // Fin onCreate

    private fun filterFightersList(query: String?) {
        val filteredList = ArrayList<FightersModel>()

        if (query != null) {
            val lowercaseQuery = query.toLowerCase(Locale.ROOT)
            for (characters in fighterList) {
                val lowercaseName = characters.name.toLowerCase(Locale.ROOT)
                if (lowercaseName.contains(lowercaseQuery)) {
                    filteredList.add(characters)
                }
            }
        }

        if (filteredList.isEmpty()) {
            Toast.makeText(this, "Aucun personnage trouvé", Toast.LENGTH_SHORT).show()
        } else {
            fightersAdapter.setFilteredFightersList(filteredList)
        }
    }


    private fun fighterListItem() {
        fighterList.add(FightersModel(R.drawable.alph, getString(R.string.alph)))
        fighterList.add(FightersModel(R.drawable.banjo, getString(R.string.banjo)))
        fighterList.add(FightersModel(R.drawable.bayonetta, getString(R.string.bayonetta)))
        fighterList.add(FightersModel(R.drawable.bowser, getString(R.string.bowser)))
        fighterList.add(FightersModel(R.drawable.bowser_jr, getString(R.string.bowser_jr)))
        fighterList.add(FightersModel(R.drawable.byleth, getString(R.string.byleth)))
        fighterList.add(FightersModel(R.drawable.captain_falcon, getString(R.string.captain_falcon)))
        fighterList.add(FightersModel(R.drawable.charizard, getString(R.string.charizard)))
        fighterList.add(FightersModel(R.drawable.chrom, getString(R.string.chrom)))
        fighterList.add(FightersModel(R.drawable.cloud, getString(R.string.cloud)))
        fighterList.add(FightersModel(R.drawable.corrin, getString(R.string.corrin)))
        fighterList.add(FightersModel(R.drawable.daisy, getString(R.string.daisy)))
        fighterList.add(FightersModel(R.drawable.dark_pit, getString(R.string.dark_pit)))
        fighterList.add(FightersModel(R.drawable.dark_samus, getString(R.string.dark_samus)))
        fighterList.add(FightersModel(R.drawable.diddy_kong, getString(R.string.diddy_kong)))
        fighterList.add(FightersModel(R.drawable.donkey_kong, getString(R.string.donkey_kong)))
        fighterList.add(FightersModel(R.drawable.dr_mario, getString(R.string.dr_mario)))
        fighterList.add(FightersModel(R.drawable.falco, getString(R.string.falco)))
        fighterList.add(FightersModel(R.drawable.fox, getString(R.string.fox)))
        fighterList.add(FightersModel(R.drawable.ganondorf, getString(R.string.ganondorf)))
        fighterList.add(FightersModel(R.drawable.mr_game_and_watch, getString(R.string.mr_game_and_watch)))
        fighterList.add(FightersModel(R.drawable.greninja, getString(R.string.greninja)))
        fighterList.add(FightersModel(R.drawable.hero, getString(R.string.hero)))
        fighterList.add(FightersModel(R.drawable.ice_climbers, getString(R.string.ice_climbers)))
        fighterList.add(FightersModel(R.drawable.ike, getString(R.string.ike)))
        fighterList.add(FightersModel(R.drawable.incineroar, getString(R.string.incineroar)))
        fighterList.add(FightersModel(R.drawable.inkling, getString(R.string.inkling)))
        fighterList.add(FightersModel(R.drawable.isabelle, getString(R.string.isabelle)))
        fighterList.add(FightersModel(R.drawable.ivysaur, getString(R.string.ivysaur)))
        fighterList.add(FightersModel(R.drawable.jigglypuff, getString(R.string.jigglypuff)))
        fighterList.add(FightersModel(R.drawable.joker, getString(R.string.joker)))
        fighterList.add(FightersModel(R.drawable.kazuya, getString(R.string.kazuya)))
        fighterList.add(FightersModel(R.drawable.ken, getString(R.string.ken)))
        fighterList.add(FightersModel(R.drawable.king_dedede, getString(R.string.king_dedede)))
        fighterList.add(FightersModel(R.drawable.king_krool, getString(R.string.king_k_rool)))
        fighterList.add(FightersModel(R.drawable.kirby, getString(R.string.kirby)))
        fighterList.add(FightersModel(R.drawable.link, getString(R.string.link)))
        fighterList.add(FightersModel(R.drawable.little_mac, getString(R.string.little_mac)))
        fighterList.add(FightersModel(R.drawable.lucario, getString(R.string.lucario)))
        fighterList.add(FightersModel(R.drawable.lucas, getString(R.string.lucas)))
        fighterList.add(FightersModel(R.drawable.lucina, getString(R.string.lucina)))
        fighterList.add(FightersModel(R.drawable.luigi, getString(R.string.luigi)))
        fighterList.add(FightersModel(R.drawable.mario, getString(R.string.mario)))
        fighterList.add(FightersModel(R.drawable.marth, getString(R.string.marth)))
        fighterList.add(FightersModel(R.drawable.mega_man, getString(R.string.megaman)))
        fighterList.add(FightersModel(R.drawable.meta_knight, getString(R.string.meta_knight)))
        fighterList.add(FightersModel(R.drawable.mewtwo, getString(R.string.mewtwo)))
        fighterList.add(FightersModel(R.drawable.mii_brawler, getString(R.string.mii_brawler)))
        fighterList.add(FightersModel(R.drawable.mii_gunner, getString(R.string.mii_gunner)))
        fighterList.add(FightersModel(R.drawable.mii_swordfighter, getString(R.string.mii_swordfighter)))
        fighterList.add(FightersModel(R.drawable.min_min, getString(R.string.minmin)))
        fighterList.add(FightersModel(R.drawable.mythra, getString(R.string.mythra)))
        fighterList.add(FightersModel(R.drawable.ness, getString(R.string.ness)))
        fighterList.add(FightersModel(R.drawable.olimar, getString(R.string.olimar)))
        fighterList.add(FightersModel(R.drawable.pacman, getString(R.string.pac_man)))
        fighterList.add(FightersModel(R.drawable.palutena, getString(R.string.palutena)))
        fighterList.add(FightersModel(R.drawable.peach, getString(R.string.peach)))
        fighterList.add(FightersModel(R.drawable.pichu, getString(R.string.pichu)))
        fighterList.add(FightersModel(R.drawable.pikachu, getString(R.string.pikachu)))
        fighterList.add(FightersModel(R.drawable.piranha_plant, getString(R.string.piranah_plant)))
        fighterList.add(FightersModel(R.drawable.pit, getString(R.string.pit)))
        fighterList.add(FightersModel(R.drawable.pokemon_trainer, getString(R.string.pokemon_trainer)))
        fighterList.add(FightersModel(R.drawable.pyra, getString(R.string.pyra)))
        fighterList.add(FightersModel(R.drawable.richter, getString(R.string.richter)))
        fighterList.add(FightersModel(R.drawable.ridley, getString(R.string.ridley)))
        fighterList.add(FightersModel(R.drawable.rob, getString(R.string.rob)))
        fighterList.add(FightersModel(R.drawable.robin, getString(R.string.robin)))
        fighterList.add(FightersModel(R.drawable.rosalina, getString(R.string.rosalina)))
        fighterList.add(FightersModel(R.drawable.roy, getString(R.string.roy)))
        fighterList.add(FightersModel(R.drawable.ryu, getString(R.string.ryu)))
        fighterList.add(FightersModel(R.drawable.samus, getString(R.string.samus)))
        fighterList.add(FightersModel(R.drawable.sephiroth, getString(R.string.sephiroth)))
        fighterList.add(FightersModel(R.drawable.sheik, getString(R.string.sheik)))
        fighterList.add(FightersModel(R.drawable.shulk, getString(R.string.shulk)))
        fighterList.add(FightersModel(R.drawable.simon, getString(R.string.simon)))
        fighterList.add(FightersModel(R.drawable.snake, getString(R.string.snake)))
        fighterList.add(FightersModel(R.drawable.sonic, getString(R.string.sonic)))
        fighterList.add(FightersModel(R.drawable.sora, getString(R.string.sora)))
        fighterList.add(FightersModel(R.drawable.squirtle, getString(R.string.squirtle)))
        fighterList.add(FightersModel(R.drawable.steve, getString(R.string.steve)))
        fighterList.add(FightersModel(R.drawable.terry, getString(R.string.terry)))
        fighterList.add(FightersModel(R.drawable.toon_link, getString(R.string.toon_link)))
        fighterList.add(FightersModel(R.drawable.villager, getString(R.string.villager)))
        fighterList.add(FightersModel(R.drawable.wario, getString(R.string.wario)))
        fighterList.add(FightersModel(R.drawable.wii_fit_trainer, getString(R.string.wii_fit_trainer)))
        fighterList.add(FightersModel(R.drawable.wolf, getString(R.string.wolf)))
        fighterList.add(FightersModel(R.drawable.yoshi, getString(R.string.yoshi)))
        fighterList.add(FightersModel(R.drawable.young_link, getString(R.string.young_link)))
        fighterList.add(FightersModel(R.drawable.zelda, getString(R.string.zelda)))
        fighterList.add(FightersModel(R.drawable.zero_suit_samus, getString(R.string.zero_suit_samus)))
        }


} // fin MainActivity