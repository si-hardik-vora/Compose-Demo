@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//          PreviewItem()
            CoroutineScopeComposable()

        }
    }
}

@Preview
@Composable
fun CoroutineScopeComposable() {

    val count = rememberSaveable { mutableStateOf(0) }
    val buttonText = rememberSaveable { mutableStateOf("Start") }
    val scope = rememberCoroutineScope()
    var text = "Counter is running ${count.value} "

    if (count.value == 10) {
        count.value = 0
        text = "Counter stopped"
        buttonText.value = "Start"
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text)
        Button(
            onClick = {
                buttonText.value = "Started"
                scope.launch {
                    Log.e("CoroutineScopeComposable", "Started: ")
                    try {
                        for (i in 1..10) {
                            count.value++
                            delay(1000)
                        }
                    } catch (e: Exception) {
                        Log.e("CoroutineScopeComposable", "Exception - ${e.message.toString()} ")
                    }
                }
            },
            modifier = Modifier
                .padding(top = 15.dp)
                .size(width = 150.dp, height = 50.dp)
        ) {
            Text(text = buttonText.value)
        }
    }
}


/*TODO
*  Here is the example of Side effect,
*  Side effect means What ever changes which can be out side of
*  composable function scope known as Side effect
*  we can easily manage side effect
*  with the help of LaunchedEffect */
@Composable
fun LaunchEffect() {

    val count = rememberSaveable { mutableStateOf(0) }
    var key = count.value % 3 == 0
//    Log.e("Count", "LaunchEffect: ${count.value}" )

    LaunchedEffect(key1 = key) {
        Log.e("Count", "LaunchEffect: ${count.value}")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Current count ${count.value}",
            color = Color.Blue
        )

        Button(
            onClick = { count.value++ },
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Click here",
                color = Color.Cyan
            )
        }


    }

}

@Composable
fun printName(name: String = "Hardik") {
    Text(
        text = name,
        fontStyle = FontStyle.Italic,
        fontSize = 36.sp,
        color = Color.Blue,
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun inputField() {

    val state = remember { mutableStateOf("") }

    TextField(
        value = state.value, onValueChange = {
            state.value = it
        },
        label = { Text(text = "Enter Value") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, top = 10.dp)

    )
}

@Composable
fun listViewItem(imgId: Int, name: String, occupation: String) {

    Row(Modifier.padding(10.dp)) {

        Image(
            painter = painterResource(id = imgId), contentDescription = "",
            Modifier.size(50.dp)
        )

        Column() {

            Text(text = name,
                fontWeight = FontWeight.Bold)

            Text(text = occupation,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp)

        }
    }
}


@Composable
fun previewComposDemos() {
    //Image Composable
    /*
          Image(
              painter = painterResource(id = R.drawable.baseline_headset_24),
              contentDescription = "Dummy Image",
              colorFilter = ColorFilter.tint(Color.Cyan),
              contentScale = ContentScale.Fit
          )
    */


    // Button Composable
    /*
         Button(
             onClick = { },
             colors = ButtonDefaults.buttonColors(
                 contentColor = Color.Red
             )
         ) {
             Text(text = "Click on me")
             Image(
                 painter = painterResource(id = R.drawable.baseline_headset_24),
                 contentDescription = "Hurt Icon"
             )
         }
    */

    // Re-Composition Text Input Field
    /*   val state = remember { mutableStateOf("") }
       TextField(value = state.value, onValueChange = {
           state.value = it
       },
           label = { Text(text = "Enter Value") },
           modifier = Modifier.fillMaxWidth()
               .padding(start = 10.dp, end = 10.dp, top = 10.dp)

       )*/

    // Column
    // Looks like Linear layout
    /*  Column(
          // Divided Maximum space
  //        verticalArrangement = Arrangement.SpaceBetween
          // Divided Space Eevenly top, Bottom and between.
  //    verticalArrangement = Arrangement.SpaceEvenly
      verticalArrangement = Arrangement.SpaceEvenly,
          horizontalAlignment = Alignment.CenterHorizontally

      ) {
          Text(text = "A")
          Text(text = "B")
      }
  */

    // ROW
    /*
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "A", fontSize = 24.sp)
            Text(text = "B", fontSize = 24.sp)
        }
    */

    // Box
    /* Box(contentAlignment = Alignment.Center) {
         Image(painter = painterResource(id = R.drawable.ic_heart), contentDescription = "")
         Image(painter = painterResource(id = R.drawable.ic_arrow), contentDescription = "")
     }*/

    // COLUMN
    /*
        Column() {
            listViewItem(R.drawable.ic_heart, "Hardik Vora", "Android Developer")
            listViewItem(R.drawable.ic_heart, "Hardik Vora", "Android Developer")
            listViewItem(R.drawable.ic_heart, "Hardik Vora", "Android Developer")
            listViewItem(R.drawable.ic_heart, "Hardik Vora", "Android Developer")
            listViewItem(R.drawable.ic_heart, "Hardik Vora", "Android Developer")
            listViewItem(R.drawable.ic_heart, "Hardik Vora", "Android Developer")
            listViewItem(R.drawable.ic_heart, "Hardik Vora", "Android Developer")

        }
    */

    // EXAMPLE OF RECOMPOSITION
    /*
    * Here we can check that the initial logged when composition function called and when clicked on
    * button the state will changed and triggered only inner logged
    */
    /* val state = remember { mutableStateOf(0.0f) }
     Log.e("TAGGED", "Logged during Initial Composition " )
     Button(onClick = {
         state.value = Math.random().toFloat()
     }) {
         Log.e("TAGGED", "Logged during Initial Composition  & Recomposition" )
         Text(text = state.value.toString())
     }*/

    // Example for State and State Hoisting
    /*TODO THIS IS OUR STATEFUL COMPOSABLE FUNCTION
    *  THIS IS ALSO UNIDIRECTIONAL FLOW -
    *   DATA MAINTAIN TOP LEVEL COMPOSABLE TO BOTTOM LEVEL COMPOSABLE*/

    var count = rememberSaveable { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        notificationCounter(count.value) { count.value++ }
        meesageBar(count.value)
    }
}

@Composable
fun notificationCounter(count: Int, increment: () -> Unit) {
    /*TODO THIS IS OUR STATELESS COMPOSABLE FUNCTION*/
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "You have sent ${count} Notifications")
        Button(onClick = { increment() }) {
            Text(text = "Send Notification")
        }

    }


}


@Composable
fun meesageBar(count: Int) {

    /*TODO THIS IS OUR STATELESS COMPOSABLE FUNCTION*/
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Image(
            imageVector = Icons.Outlined.Favorite,
            contentDescription = "",
            Modifier.padding(4.dp)
        )
        Text(text = "Message sent so far - $count")

    }
}
