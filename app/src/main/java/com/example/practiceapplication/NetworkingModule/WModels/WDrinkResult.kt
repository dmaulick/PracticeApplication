package com.example.practiceapplication.NetworkingModule.WModels

import com.google.gson.annotations.SerializedName

class WDrinkResult(
    @SerializedName("drinks") val drinks: List<WDrinkModel>
)