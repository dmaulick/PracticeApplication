package com.example.practiceapplication.MainFeature.DrinksList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiceapplication.Dagger.DaggerAppComponent
import com.example.practiceapplication.Dagger.DaggerDrinksListComponent
import com.example.practiceapplication.Dagger.DrinksListModule
import com.example.practiceapplication.MainFeature.DrinksViewModelFactory
import com.example.practiceapplication.MainFeature.Resource
import com.example.practiceapplication.MainFeature.Status
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel
import com.example.practiceapplication.PracticeApp
import com.example.practiceapplication.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.drink_list_fragment.*
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

class DrinkListFragment : Fragment() {

    private lateinit var drinksAdaptor: DrinksAdaptor

    @Inject lateinit var drinkListViewModelFactory: DrinksViewModelFactory

    private val viewModel: DrinkListViewModel by viewModels {
        drinkListViewModelFactory
    }

//            by lazy {
//        ViewModelProviders.of(this).get(DrinkListViewModel::class.java)
//    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        DaggerDrinksListComponent.builder()
            .appComponent((activity?.application as? PracticeApp)?.appComponent)
            .drinksListModule(DrinksListModule())
            .build()
            .inject(this) ?: throw Exception("Could not inject in Drinks list Fragment!")

        return inflater.inflate(R.layout.drink_list_fragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1) Connect adapters and recycler view
        initDrinkRecyclerView()

        // 2) Initialize view properties, set click listeners, etc.

        // 3) Subscribe to state
        subscribeToViewModel()
    }

    private fun initDrinkRecyclerView() {
        drink_list_recycler_view.layoutManager = LinearLayoutManager(activity)
        drinksAdaptor = DrinksAdaptor(
            arrayListOf<WDrinkModel>(
                WDrinkModel("a", "b", "c", "d", "e"),
                WDrinkModel("1a", "b1", "1c", "1d", "1e"),
                WDrinkModel("2a", "2b", "2c", "2d", "2e")
            )
        )
        drink_list_recycler_view.adapter = drinksAdaptor
    }

    private fun subscribeToViewModel() {
        viewModel.drinksListLiveData.observe(this, Observer { onDrinkListUpdated(it) })
    }

    private fun onDrinkListUpdated(drinksList: Resource<List<WDrinkModel>>) {

        when (drinksList.status) {
            Status.SUCCESS -> {
                view?.run {
                    Snackbar.make(this.rootView, "Success Load of drinks.", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                } ?: throw Exception("No root view in success")

            }
            Status.LOADING -> {
                view?.run {
                    Snackbar.make(this.rootView, "Loading drinks.", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                } ?: throw Exception("No root view in loading")
            }
            Status.ERROR -> {
                view?.run {
                    Snackbar.make(this.rootView, "Error Load of drinks.", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                } ?: throw Exception("No root view in error")
            }
        }

    }

}