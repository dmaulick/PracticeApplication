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
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class DrinkListViewModel @Inject constructor(private val drinksApiSource: IDrinksApiSource) : ViewModel() {


    val drinksListLiveData = MutableLiveData<Resource<List<WDrinkModel>>>()


    fun getDrinksList() {

        drinksListLiveData.postValue(Resource.loading())

        CoroutineScope(Dispatchers.IO).launch {

        }

    }

}