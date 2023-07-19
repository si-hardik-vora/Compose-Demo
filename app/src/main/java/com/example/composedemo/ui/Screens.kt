package com.example.composedemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.R

@Preview(showBackground = true)
@Composable
fun Preview() {
    BlogCategory(imgId = R.drawable.ic_heart, name = "Vora Hardik", subTitle = "Android Developer")
}


@Composable
fun BlogCategory(imgId: Int, name: String, subTitle: String) {

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ), modifier = Modifier.padding(8.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {

            Image(
                painter = painterResource(id = imgId),
                contentDescription = "",
                modifier = Modifier
                    .padding(10.dp)
                    .size(50.dp)
                    .weight(.2f)
            )

            ItemDescription(name, subTitle, Modifier.weight(.8f))

        }

    }
}

@Composable
private fun ItemDescription(name: String, subTitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = subTitle,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Thin
        )
    }
}