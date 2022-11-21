package com.geekbrains.stopwatch.model

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow

abstract class BaseViewModel: ViewModel() {

    abstract val firstData: Flow<String>
    abstract val secondData: Flow<String>
    protected abstract val scope: CoroutineScope

    abstract fun startFirstStopwatch()
    abstract fun pauseFirstStopwatch()
    abstract fun stopFirstStopwatch()
    abstract fun startSecondStopwatch()
    abstract fun pauseSecondStopwatch()
    abstract fun stopSecondStopwatch()

    override fun onCleared() {
        scope.cancel()
        super.onCleared()
    }
}