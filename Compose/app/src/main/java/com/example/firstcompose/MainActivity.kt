package com.example.firstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewItem()
        }
    }
}

@Preview(showBackground = true, name = "Preview1", heightDp = 500, widthDp = 500)
@Composable
fun PreviewFunction() {
//    PrintTextData("Function passed data")
//    ButtonComposable()
//    PrintOtherData("Function passed data")
//    InputTextPreview()
//    TextInput()
//    RowAndColumnPreview()
//    FrameDemonstrationFunction()
//    ListViewItem()
//    ColumnOfListItems()
//    ChainedSequentialModifier()
//    CircularImage()
//    PreviewItem()
//    NumericalTextInput()
    NotificationScreen()
}

@Composable
fun CircularImage() {
    Image(
        painter = painterResource(id = androidx.core.R.drawable.notify_panel_notification_icon_bg),
        contentDescription = "shape",
        modifier = Modifier
            .background(Color.Black)
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, Color.LightGray, CircleShape)
    )
}

@Composable
fun ChainedSequentialModifier() {
    Text(text = "Hello",
        modifier = Modifier
            .background(Color.Blue)
            .size(200.dp)
            .border(2.dp, Color.Red)
            .padding(16.dp)
            .clip(CircleShape)
            .background(Color.Yellow)
            .clickable { }
    )
}

@Composable
fun ColumnOfListItems() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ListViewItem("Abhishek Singh", "Software Developer", Modifier.background(Color.Cyan))
        ListViewItem("Rajesh Singh", "Software Tester", Modifier.background(Color.Cyan))
        ListViewItem("Rakesh Singh", "Software Architect", Modifier.background(Color.Cyan))
        ListViewItem("Arun Singh", "Software Maintenance", Modifier.background(Color.Cyan))
        ListViewItem("Akash Singh", "Principal Architect", Modifier.background(Color.Cyan))
    }
}

@Composable
fun ListViewItem(name: String, designation: String, modifier: Modifier) {
    Row(modifier.padding(8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        Image(
            painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
            contentDescription = "ProfileImage",
            alignment = Alignment.Center,
            modifier = Modifier.size(25.dp)
        )
        Column {
            Text(text = name, fontWeight = FontWeight.ExtraBold)
            Text(text = designation, fontWeight = FontWeight.Medium, fontSize = 12.sp)
        }
    }
}

@Composable
fun FrameDemonstrationFunction() {
    Box(contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "PreviewImage"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "PreviewImage",
            colorFilter = ColorFilter.tint(Color.Blue)
        )
    }

}

@Composable
fun RowAndColumnPreview() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "A", fontSize = 24.sp)
        Text(text = "B", fontSize = 24.sp)
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "C", fontSize = 24.sp)
            Text(text = "D", fontSize = 24.sp)
        }
    }
}

@Composable
fun PrintTextData(data: String = "Development Tutorial") {
    Text(
        text = data,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Red,
        fontSize = 36.sp,
        textAlign = TextAlign.Right
    )
}

@Composable
fun PrintImageData() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "PreviewImage",
        colorFilter = ColorFilter.tint(Color.Blue),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun ButtonComposable() {
    Button(
        onClick = {}, colors = ButtonDefaults.buttonColors(
            contentColor = Color.White
        )
    ) {
        Text(text = "Hello")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "PreviewImage"
        )
    }
}

@Composable
fun InputTextPreview() {
    TextField(value = "Hello World",
        onValueChange = {},
        label = { Text(text = "Enter message") },
        placeholder = {})
}

@Composable
fun TextInput() {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {
            Log.d("MainActivity", "checking type : $it")
            state.value = it
        },
        label = { Text(text = "Enter message") },
    )
}


// RECOMPOSITION EXAMPLE HERE
@Composable
fun NumericalTextInput() {
    val state = remember { mutableStateOf(0.0) }
    Log.d("MainActivity", "checking recomposition : logged during initial composition")
    Button(onClick = {state.value = Math.random() }) {
        Log.d("MainActivity", "checking recomposition : logged during initial composition AND recomposition")
        Text(text = state.value.toString())
    }
}

@Composable
fun PrintOtherData(data: String = "Another development Tutorial") {
    Text(text = data)
}
