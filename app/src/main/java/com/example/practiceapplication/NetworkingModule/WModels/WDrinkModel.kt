package com.example.practiceapplication.NetworkingModule.WModels

import com.google.gson.annotations.SerializedName

class WDrinkModel(
    @SerializedName("idDrink") val drinkId: String?,
    @SerializedName("strDrink") val drinkName: String?,
    @SerializedName("strCategory") val drinkCategory: String?,
    @SerializedName("strAlcoholic") val alcoholic: String?,
    @SerializedName("strInstructions") val instructions: String?
)