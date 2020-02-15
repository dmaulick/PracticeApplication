package com.example.practiceapplication.MainFeature.DrinksList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practiceapplication.MainFeature.Resource
import com.example.practiceapplication.NetworkingModule.WModels.WDrinkModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class DrinkListViewModel(private val testViewModelParam: String) : ViewModel(), IDrinksListViewModel {


    val drinksListLiveData = MutableLiveData<Resource<List<WDrinkModel>>>()


    override fun getDrinksList() {

        drinksListLiveData.postValue(Resource.loading())

        CoroutineScope(Dispatchers.IO).launch {

        }

    }

}