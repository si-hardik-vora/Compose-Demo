@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composedemo

import android.os.Bundle
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            PreviewItem()
            previewComposDemos()

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


@Preview(showBackground = true, name = "message", showSystemUi = true)
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
