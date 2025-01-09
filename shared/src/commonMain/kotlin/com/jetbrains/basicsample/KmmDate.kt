package com.jetbrains.basicsample

import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn

fun getToday(): String {
    val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
    return today.dayOfMonth.toString() + " / " + today.monthNumber.toString() + " / " + today.year.toString()
}