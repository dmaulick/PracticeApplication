package com.example.practiceapplication.MainFeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practiceapplication.MainFeature.DrinksList.DrinkListViewModel
import com.example.practiceapplication.MainFeature.DrinksList.IDrinksApiSource
import javax.inject.Inject

class DrinksViewModelFactory @Inject constructor(private val drinksApiSource: IDrinksApiSource): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DrinkListViewModel::class.java)) {
            return modelClass.getConstructor(IDrinksApiSource::class.java)
                .newInstance(drinksApiSource)
        }
        else {
            throw Exception("DrinksViewModelFactory could not find class type: '$modelClass'.")
        }
    }

}