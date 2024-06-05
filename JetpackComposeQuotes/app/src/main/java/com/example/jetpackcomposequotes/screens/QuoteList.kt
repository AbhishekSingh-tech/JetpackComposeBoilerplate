package com.example.jetpackcomposequotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.jetpackcomposequotes.models.Quote

@Composable
fun QuoteList(data : Array<Quote>, onClick : (quote:Quote)->Unit){
    LazyColumn {
        items(data){
            QuoteListItem(it,onClick)
        }
    }
}