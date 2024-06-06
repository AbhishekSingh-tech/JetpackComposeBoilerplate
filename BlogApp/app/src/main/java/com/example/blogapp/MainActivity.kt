package com.example.blogapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blogapp.ui.theme.BlogAppTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogAppTheme {
                // A surface container using the 'background' color from the theme
//               App()
//                LaunchEffectComposable()
//                RememberScopeComposable()
//                StandardComposableWithNoSideEffectManagement()
//                RememberUpdatedStateDemoComposable()
//                DisposableEffectDemo()
                ProducedAndDerivedStateDemo()
            }
        }
    }
}

@Composable
fun ProducedAndDerivedStateDemo() {
    var tableOf = remember {
        mutableIntStateOf(5)
    }

    var index = produceState(initialValue = 1) {
        while (value < 10) {
            delay(5000)
            value++
        }
    }
    var message = remember {
        derivedStateOf {
            "${tableOf.intValue} * ${index.value} = ${tableOf.intValue * index.value}"
        }
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize(1f)) {
        Text(text = message.value, style = MaterialTheme.typography.headlineSmall)
    }
}

@Composable
fun DisposableEffectDemo() {
    var state = remember {
        mutableStateOf(false)
    }
    DisposableEffect(key1 = state.value) {
        Log.d("MainActivity", "DisposableEffect started")
        onDispose {
            Log.d("MainActivity", "DisposableEffect cleaning up")
// use onDispose() to get rid of listeners/ objects etc that would otherwise cause memory leaks if this composable is left behind
        }
    }

    Button(onClick = { state.value = !state.value }) {
        Text(text = "Change State")
    }
}


@Composable
fun RememberUpdatedStateDemoComposable() {
    var counter = remember {
        mutableIntStateOf(0)
    }
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        counter.intValue = 10
    }
    Counter(counter.intValue)
}

@Composable
fun Counter(value: Int) {
    var state = rememberUpdatedState(newValue = value)
    LaunchedEffect(key1 = Unit) {
        delay(5000)
        Log.d("MainActivity", "inside Counter : with value :${state.value}")
    }
    Text(text = value.toString())
}


@Composable
fun StandardComposableWithNoSideEffectManagement() {
    var counter = remember {
        mutableIntStateOf(0)
    }
    var text = "Counter is running ${counter.intValue}"
    if (counter.intValue == 10) {
        text = "Counter stopped"
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(8.dp)) {
        Text(text = text)
        Button(onClick = {
            counter.intValue++
        }) {
            Text(text = "Increase Count")
        }
    }


}

@Composable
fun LaunchEffectComposable() {
    var counter = remember {
        mutableIntStateOf(0)
    }
    LaunchedEffect(key1 = Unit) {
        Log.d("MainActivity", "inside LaunchEffectComposable : STARTED")
        try {
            for (i in 1..10) {
                counter.intValue++
                delay(1000)
            }
        } catch (e: Exception) {
            Log.d("MainActivity", "inside LaunchEffectComposable : CATCH EXCEPTION: e: $e")
        }
    }
    var text = "Counter is running ${counter.intValue}"
    if (counter.intValue == 10) {
        text = "Counter stopped"
    }
    Text(text = text)
}

@Composable
fun RememberScopeComposable() {
    var counter = remember {
        mutableIntStateOf(0)
    }
    var scope = rememberCoroutineScope()

    var text = "Counter is running ${counter.intValue}"
    if (counter.intValue == 10) {
        text = "Counter stopped"
    }
    Column {
        Text(text = text)
        Button(onClick = {
            scope.launch {
                Log.d("MainActivity", "inside rememberCoroutineScope : STARTED")
                try {
                    for (i in 1..10) {
                        counter.intValue++
                        delay(1000)
                    }
                } catch (e: Exception) {
                    Log.d("MainActivity", "inside rememberCoroutineScope : CATCH EXCEPTION: e: $e")
                }
            }
        }) {
            Text(text = "Start")
        }
    }
}

@Composable
fun App() {

    //SIDE EFFECT HANDLING
    LaunchedEffect(key1 = Unit) {
        // perform API call to fetch data
        // Launched effect is execute only based on the value defined in key. If key value is Unit : one call. if key value is updated, call happens again
        // Launched effect is a new coroutine
    }

    var theme = remember {
        mutableStateOf(false)
    }
    BlogAppTheme(theme.value) {
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(1f)
                .padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "BlogApp")
            Button(onClick = { theme.value = !theme.value }) {
                Text(text = "Change theme")
            }
        }

    }

}