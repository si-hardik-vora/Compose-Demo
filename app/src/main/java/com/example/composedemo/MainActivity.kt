@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            inputField()
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


@Composable
fun inputField() {

    val state = remember { mutableStateOf("") }

    TextField(value = state.value, onValueChange = {
        state.value = it
    },
        label = { Text(text = "Enter Value") }
    )
}


@Preview(showBackground = true, name = "message", showSystemUi = true)
@Composable
fun preview() {
    //Image Composable
    /*  Image(
          painter = painterResource(id = R.drawable.baseline_headset_24),
          contentDescription = "Dummy Image",
          colorFilter = ColorFilter.tint(Color.Cyan),
          contentScale = ContentScale.Fit
      )*/


    // Button Composable
    /* Button(
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
     }*/


}