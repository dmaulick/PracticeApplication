package com.example.practiceapplication.MainFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel
import com.example.practiceapplication.R
import kotlinx.android.synthetic.main.drink_list_fragment.*

class DrinkListFragment : Fragment() {

    private lateinit var drinksAdaptor: DrinksAdaptor

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.drink_list_fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1) Connect adapters and recycler view
        initDrinkRecyclerView()

        // 2) Initialize view properties, set click listeners, etc.

        // 3) Subscribe to state
    }

    private fun initDrinkRecyclerView() {
        drink_list_recycler_view.layoutManager = LinearLayoutManager(activity)
        drinksAdaptor = DrinksAdaptor(arrayListOf<WDrinkModel>(
            WDrinkModel("a", "b", "c", "d", "e"),
            WDrinkModel("1a", "b1", "1c", "1d", "1e"),
            WDrinkModel("2a", "2b", "2c", "2d", "2e")
        ))
        drink_list_recycler_view.adapter = drinksAdaptor
    }

}