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
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class DrinkListViewModel @Inject constructor(private val drinksListRepository: IDrinksListRepository) : ViewModel() {


    val drinksListLiveData = MutableLiveData<Resource<List<WDrinkModel>>>()


    fun getDrinksList() {

        drinksListLiveData.postValue(Resource.loading())

        CoroutineScope(Dispatchers.Default).launch {
            Timber.d("Starting getDrink try")
            try {
                val drinkList = drinksListRepository.getExpectedListOfDrinks()
                drinksListLiveData.postValue(Resource.success(drinkList))
                Timber.d("Done with getDrink try")
            }
            catch (e: Exception) {
                Timber.e(e)
                drinksListLiveData.postValue(Resource.error(e))
            }

            Timber.d("Done with getDrink in vm")
        }

    }

}