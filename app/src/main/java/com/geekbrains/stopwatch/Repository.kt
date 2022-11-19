package com.geekbrains.stopwatch

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class Repository(private val dataSource: DataSource = DataSource()) {
    val userData: Flow<Data> = dataSource.data.map { data ->
        Data(data)
    }
}