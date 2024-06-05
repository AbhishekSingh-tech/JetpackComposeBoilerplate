package com.example.jetpackcomposequotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposequotes.DataManager
import com.example.jetpackcomposequotes.R
import com.example.jetpackcomposequotes.models.Quote


//@Preview
@Composable
fun QuoteDetail(quote: Quote,onClick:(quote:Quote) -> Unit) {

    BackHandler {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xC1c1c1)
                    )
                )
            )
            .clickable {
                onClick(quote)
            }
    ) {
        Card(elevation = CardDefaults.cardElevation(4.dp), modifier = Modifier.padding(32.dp)) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .background(Color.LightGray)
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp, 24.dp)
            ) {

                Image(
                    imageVector = Icons.Filled.Create,
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier
                        .size(60.dp)
                        .rotate(180F)
                        .background(Color.Black),
                    contentDescription = "Quote"
                )
//
                Text(
                    text = quote.text,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp, 8.dp, 0.dp, 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodySmall,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                    fontWeight = FontWeight.Thin,
                    modifier = Modifier.padding(top = 4.dp)
                )


            }
        }
    }
}