package com.example.jetpackcomposequotes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposequotes.screens.QuoteDetail
import com.example.jetpackcomposequotes.screens.QuoteListItem
import com.example.jetpackcomposequotes.screens.QuoteListScreen
import com.example.jetpackcomposequotes.ui.theme.JetpackComposeQuotesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadAssetsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTING) {
            QuoteListScreen(data = DataManager.data) {
                CoroutineScope(Dispatchers.IO).launch {
                    DataManager.switchPages(it)
                }
            }
        } else {
            DataManager.currentQuote?.let { it ->
                QuoteDetail(quote = it) {
                    Log.d("MainActivity", "checking on Click from quoteDetail")
                    CoroutineScope(Dispatchers.IO).launch {
                        DataManager.switchPages(it)
                    }
                }
            }
        }

    } else {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
            Text(text = "Loading...", style = MaterialTheme.typography.labelMedium)
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL
}