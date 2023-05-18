package com.stevenyambos.smashhereapp

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FightersListAdapter(var charactersList: List<FightersList>) :
    RecyclerView.Adapter<FightersListAdapter.FightersViewHolder>() {

        inner class FightersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val fighterIcon : ImageView = itemView.findViewById(R.id.fighter_cardView_image)
            val fighterName : TextView = itemView.findViewById(R.id.fighter_cardView_text)
        }

    fun setFilteredList(charactersList: List<FightersList>){
        this.charactersList = charactersList
        notifyDataSetChanged() /* La méthode notifyDataSetChanged() est une méthode utilisée dans le développement Android pour informer un adaptateur (Adapter) lié à une vue (View) que les données sous-jacentes ont été modifiées. Cela permet à l'adaptateur de mettre à jour la vue avec les nouvelles données.
Lorsque vous utilisez un adaptateur pour afficher des données dans une vue, telles que des éléments dans une liste ou une grille, l'adaptateur agit comme un pont entre les données et la vue. Lorsque les données sont modifiées, par exemple en ajoutant, en supprimant ou en modifiant des éléments, il est nécessaire de notifier l'adaptateur pour qu'il puisse mettre à jour la vue en conséquence.
C'est là que la méthode notifyDataSetChanged() entre en jeu. Lorsque vous appelez cette méthode sur votre adaptateur, il indique à la vue associée qu'il y a eu des modifications dans les données et qu'elle doit être mise à jour en conséquence. La vue va alors demander à l'adaptateur de lui fournir les données mises à jour, et les modifications seront reflétées dans l'interface utilisateur. */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FightersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fighters_card_view, parent,false)
        return FightersViewHolder(view)
    }

    override fun onBindViewHolder(holder: FightersViewHolder, position: Int) {
        holder.fighterIcon.setImageResource(charactersList[position].image)
        holder.fighterName.text = charactersList[position].name
    }

    override fun getItemCount(): Int {
        return charactersList.size
    }

}