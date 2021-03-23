/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        FirstPart()
    }
}

@Composable
fun FirstPart() {

    LazyColumn {
        item {
            Column(
                modifier = Modifier
                    .background(color = Color(if (isSystemInDarkTheme()) 0xFF9FA8DA else 0xFFFFC107))
                    .fillMaxWidth()
            ) {
                Row {
                    Column {
                        Text(
                            text = "Sunrise",
                            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                            style = MaterialTheme.typography.h3,
                            color = Color.White
                        )

                        Text(
                            text = "20" + "\u2103",
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .semantics { "Temperature is 20℃" },
                            style = MaterialTheme.typography.h1,
                            color = Color.White
                        )
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Image(
                            modifier = Modifier.padding(top = 50.dp, start = 50.dp),
                            painter = painterResource(id = R.drawable.ic_sunset),
                            contentDescription = "Cloudy Atmospher"
                        )
                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.ic_wave),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 100.dp)
                        .fillMaxWidth()
                        .height(80.dp)
                )
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                        .wrapContentWidth(Alignment.Start),
                    text = "Today",
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp, top = 10.dp, bottom = 10.dp)
                        .wrapContentWidth(Alignment.End)
                        .semantics { "City is Ahemdabad, India" },
                    text = "Ahemdabad, India",
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
        }

        item {
            DayWeathers(dayLists)
        }

        item {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp)
                    .wrapContentWidth(Alignment.Start),
                text = "Weekly Forecast",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }

        item {
            WeekWeathers(weekLists)
        }
    }
}

@Composable
fun DayWeathers(dayLists: List<DayWeather>) {
    LazyRow(modifier = Modifier.fillMaxWidth(), state = rememberLazyListState()) {
        items(dayLists) { dayList ->
            DayItem(dayWeather = dayList)
        }
    }
}

@Composable
fun DayItem(dayWeather: DayWeather) {
    Column(
        modifier = Modifier
            .padding(5.dp)
            .width(60.dp)
            .height(120.dp)
            .background(
                color = Color.Transparent,
                shape = RoundedCornerShape(10.dp)
            )
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                ),
                shape = RoundedCornerShape(10.dp)
            )
            .clickable(onClick = {})
            .semantics { "${dayWeather.time} and ${dayWeather.type} weather and temperature is ${dayWeather.temp}" }
            .alpha(if (isSystemInDarkTheme()) 1f else 0.5f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = dayWeather.time,
            modifier = Modifier
                .padding(top = 10.dp),
            style = MaterialTheme.typography.caption
        )

        Image(
            painter = painterResource(id = dayWeather.pic),
            contentDescription = dayWeather.type,
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
        )

        Text(
            text = dayWeather.type,
            style = MaterialTheme.typography.caption
        )

        Text(
            text = "${dayWeather.temp} \u2103",
            modifier = Modifier
                .padding(bottom = 10.dp),
            style = MaterialTheme.typography.caption
        )
    }
}

@Composable
fun WeekWeathers(weekLists: List<WeekWeather>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(400.dp),
        state = rememberLazyListState()
    ) {
        items(weekLists) { weekList ->
            WeekItem(weekWeather = weekList)
        }
    }
}

@Composable
fun WeekItem(weekWeather: WeekWeather) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .semantics { "${weekWeather.day} and date is ${weekWeather.date} and ${weekWeather.type} weather and temperature is ${weekWeather.tempRange}" },
        shape = RoundedCornerShape(5.dp),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.padding(start = 10.dp, end = 20.dp)) {
                Text(
                    text = weekWeather.day,
                    style = MaterialTheme.typography.caption,
                )
                Text(
                    modifier = Modifier.alpha(0.5f),
                    text = weekWeather.date,
                    style = MaterialTheme.typography.caption
                )
            }

            Image(
                modifier = Modifier
                    .padding(start = 15.dp, end = 5.dp)
                    .width(50.dp)
                    .height(50.dp),
                painter = painterResource(id = weekWeather.pic),
                contentDescription = weekWeather.type
            )

            Text(
                modifier = Modifier
                    .padding(start = 5.dp, end = 20.dp)
                    .alpha(0.5f),
                text = weekWeather.type,
                style = MaterialTheme.typography.caption
            )

            Text(
                modifier = Modifier
                    .padding(start = 15.dp, end = 5.dp),
                text = weekWeather.tempRange,
                style = MaterialTheme.typography.caption
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
