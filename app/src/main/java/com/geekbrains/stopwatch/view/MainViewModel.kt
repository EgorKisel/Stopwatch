package com.geekbrains.stopwatch.view

import com.geekbrains.stopwatch.model.Stopwatch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(
    private val firstStopwatch: Stopwatch,
    private val secondStopwatch: Stopwatch,
) : BaseViewModel() {

    override val firstData = MutableStateFlow("")
    override val secondData = MutableStateFlow("")
    override val scope = CoroutineScope(Dispatchers.IO)

    init {
        firstStopwatch.ticker
            .onEach {
                firstData.value = it
            }
            .launchIn(scope)
        secondStopwatch.ticker
            .onEach {
                secondData.value = it
            }
            .launchIn(scope)
    }

    override fun startFirstStopwatch() {
        firstStopwatch.start()
    }

    override fun pauseFirstStopwatch() {
        firstStopwatch.pause()
    }

    override fun stopFirstStopwatch() {
        firstStopwatch.stop()
    }

    override fun startSecondStopwatch() {
        secondStopwatch.start()
    }

    override fun pauseSecondStopwatch() {
        secondStopwatch.pause()
    }

    override fun stopSecondStopwatch() {
        secondStopwatch.stop()
    }
}