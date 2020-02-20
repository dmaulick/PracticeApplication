package com.example.practiceapplication.Utils.ContextUtils

import android.content.Context

class StringContext(private val context: Context): IStringContext {
    override fun getString(id: Int): String {
        return context.getString(id)
    }
}