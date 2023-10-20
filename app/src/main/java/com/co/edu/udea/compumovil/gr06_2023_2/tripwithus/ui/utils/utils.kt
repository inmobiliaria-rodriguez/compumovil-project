package com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.ui.utils

import android.content.Context
import com.co.edu.udea.compumovil.gr06_2023_2.tripwithus.model.Tour
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

fun getJsonDataFromAsset(
    context: Context,
    fileName: String
): String? {
    val jsonString: String

    try {
        jsonString = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (exp: IOException) {
        exp.printStackTrace()
        return null
    }

    return jsonString
}

fun tourList(context: Context): MutableList<Tour> {
    val jsonFileString = getJsonDataFromAsset(context = context, "tours.json")
    val type = object : TypeToken<List<Tour>>() {}.type
    return Gson().fromJson(jsonFileString, type)
}