package com.example.practiceapplication.MainFeature.DrinksList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceapplication.MainFeature.DrinksList.DrinksAdaptor.DrinksViewHolder
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel
import com.example.practiceapplication.R
import kotlinx.android.synthetic.main.drinks_view_holder.view.*

class DrinksAdaptor(private val drinksList: ArrayList<WDrinkModel>) : RecyclerView.Adapter<DrinksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val viewHolder = LayoutInflater.from(parent.context)
            .inflate(R.layout.drinks_view_holder, parent, false)
        return DrinksViewHolder(viewHolder)
    }

    override fun getItemCount(): Int {
        return drinksList.size
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        val drink = drinksList[position]

        holder.drinkId.text = drink.drinkId
        holder.drinkCategory.text = drink.drinkCategory
        holder.drinkName.text = drink.drinkName
    }


    inner class DrinksViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val drinkId: TextView = itemView.drink_id
        val drinkCategory: TextView = itemView.drink_category
        val drinkName: TextView = itemView.drink_name

    }
}