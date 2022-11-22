package com.geekbrains.stopwatch.di

import com.geekbrains.stopwatch.model.*
import com.geekbrains.stopwatch.view.BaseViewModel
import com.geekbrains.stopwatch.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<TimestampProvider> { TimestampProvider.Base() }
    single<ElapsedTimeCalculator> { ElapsedTimeCalculator.Base(timestampProvider = get()) }
    single<StopwatchStateCalculator> {
        StopwatchStateCalculator.Base(
            timestampProvider = get(),
            elapsedTimeCalculator = get()
        )
    }
    single<TimestampMillisecondsFormatter> { TimestampMillisecondsFormatter.Base() }
    factory<StopwatchStateHolder> {
        StopwatchStateHolder.Base(
            stopwatchStateCalculator = get(),
            elapsedTimeCalculator = get(),
            timestampMillisecondsFormatter = get()
        )
    }
    factory<Stopwatch> { Stopwatch.StopwatchListOrchestrator(stopwatchStateHolder = get()) }

    viewModel<BaseViewModel> {
        MainViewModel(
            firstStopwatch = get(),
            secondStopwatch = get()
        )
    }
}