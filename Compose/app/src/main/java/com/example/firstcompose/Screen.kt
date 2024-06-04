package com.example.firstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(heightDp = 300)
@Composable
fun PreviewItem() {

    LazyColumn(content = {
        items(getCategoryList()){item ->
            BlogCategory(image = item.img, title = item.title, subTitle = item.subtitle)
        }
    })

//    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
//        getCategoryList().map { item ->
//            BlogCategory(item.img,item.title,item.subtitle)
//        }
//    }
}

@Composable
fun BlogCategory(image : Int, title: String = "Programming", subTitle: String = "Learn different languages") {
    Card(elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = "Icon for rv item",
                modifier = Modifier
                    .size(40.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(Modifier.weight(.8f), title, subTitle)
        }
    }
}

@Composable
private fun ItemDescription(modifier: Modifier, title: String, subTitle: String) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = subTitle,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Thin
        )
    }
}

data class Category(val img: Int, val title: String, val subtitle: String)


fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_answer_video,
            "Abhishek Singh",
            "Software Developer"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_answer_low,
            "Rajesh Singh",
            "Software Tester"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_decline,
            "Rakesh Singh",
            "Software Architect"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_answer_video_low,
            "Arun Singh",
            "Software Maintenance"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_answer,
            "Akash Singh",
            "Principal Architect"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_answer_video,
            "Abhishek Singh",
            "Software Developer"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_answer_low,
            "Rajesh Singh",
            "Software Tester"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_decline,
            "Rakesh Singh",
            "Software Architect"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_answer_video_low,
            "Arun Singh",
            "Software Maintenance"
        )
    )
    list.add(
        Category(
            androidx.core.R.drawable.ic_call_answer,
            "Akash Singh",
            "Principal Architect"
        )
    )
    return list
}