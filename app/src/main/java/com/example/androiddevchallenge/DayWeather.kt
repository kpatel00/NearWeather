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

data class DayWeather(
    val temp: Int,
    val time: String,
    val type: String,
    @DrawableRes val pic: Int
)

val dayLists = listOf(
    DayWeather(23, "Now", "Cloudy", R.drawable.ic_cloudymoon),
    DayWeather(22, "6:52AM", "Sunrise", R.drawable.ic_sunset),
    DayWeather(22, "7AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(23, "8AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(24, "9AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(26, "10AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(30, "11AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(35, "12PM", "Sunny", R.drawable.ic_sunny),
    DayWeather(36, "1PM", "Sunny", R.drawable.ic_sunny),
    DayWeather(35, "2PM", "Sunny", R.drawable.ic_sunny),
    DayWeather(30, "3PM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(28, "4PM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(25, "5PM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(23, "6PM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(23, "7PM", "Sunset", R.drawable.ic_sunset),
    DayWeather(23, "8PM", "Cloudy", R.drawable.ic_cloudymoon),
    DayWeather(22, "9PM", "Cloudy", R.drawable.ic_cloudymoon),
    DayWeather(23, "10PM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(22, "11PM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(20, "12AM", "Moon", R.drawable.ic_moon),
    DayWeather(19, "1AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(19, "2AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(20, "3AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(21, "4AM", "Cloudy", R.drawable.ic_cloudysun),
    DayWeather(22, "5AM", "Cloudy", R.drawable.ic_cloudysun)
)
