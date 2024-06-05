package com.example.jetpackcomposequotes

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import com.example.jetpackcomposequotes.models.Quote
import com.google.gson.Gson

object DataManager {
    var currentPage = mutableStateOf(Pages.LISTING)
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)
    var currentQuote : Quote? = null

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json,Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?){
        Log.d("DataManager","currentPage : ${currentPage.value}")
        currentQuote = quote
        if (currentPage.value == Pages.LISTING){
            currentPage.value = Pages.DETAIL
        }else currentPage.value = Pages.LISTING
    }
}