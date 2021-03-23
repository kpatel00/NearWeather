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

import androidx.annotation.DrawableRes

data class WeekWeather(
    val tempRange: String,
    val day: String,
    val date: String,
    val type: String,
    @DrawableRes val pic: Int
)

val weekLists = listOf(
    WeekWeather("20℃ - 35℃", "Today", "23/3", "Cloudy", R.drawable.ic_cloudysun),
    WeekWeather("15℃ - 30℃", "Wed", "24/3", "Cloudy", R.drawable.ic_cloudysun),
    WeekWeather("23℃ - 38℃", "Thu", "25/3", "Sunny", R.drawable.ic_sunny),
    WeekWeather("20℃ - 35℃", "Fri", "26/3", "Cloudy", R.drawable.ic_cloudysun),
    WeekWeather("20℃ - 35℃", "Sat", "27/3", "Cloudy", R.drawable.ic_cloudysun),
    WeekWeather("15℃ - 30℃", "Sun", "28/3", "Cloudy", R.drawable.ic_cloudysun),
    WeekWeather("23℃ - 38℃", "Mon", "29/3", "Sunny", R.drawable.ic_sunny)
)
