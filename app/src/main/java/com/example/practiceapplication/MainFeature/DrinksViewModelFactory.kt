package com.example.practiceapplication.MainFeature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practiceapplication.MainFeature.DrinksList.DrinkListViewModel
import javax.inject.Inject

class DrinksViewModelFactory @Inject constructor(private val testViewModelParam: String): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DrinkListViewModel::class.java)) {
            return modelClass.getConstructor(String::class.java)
                .newInstance(testViewModelParam)
        }
        else {
            throw Exception("DrinksViewModelFactory could not find class type: '$modelClass'.")
        }
    }

}