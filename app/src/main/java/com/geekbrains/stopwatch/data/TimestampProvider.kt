package com.geekbrains.stopwatch.data

interface TimestampProvider {
    fun getMilliseconds(): Long
}