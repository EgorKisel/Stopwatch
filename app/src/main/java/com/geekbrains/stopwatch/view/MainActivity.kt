package com.geekbrains.stopwatch.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.stopwatch.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: BaseViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observeData()
        setButtonsClicks()
    }

    private fun observeData() {
        viewModel.firstData
            .onEach {
                binding.textTime.text = it
            }
            .launchIn(scope)

        viewModel.secondData
            .onEach {
                binding.textTimeSecond.text = it
            }
            .launchIn(scope)
    }

    private fun setButtonsClicks() {
        with(binding) {
            buttonStart.setOnClickListener { viewModel.startFirstStopwatch() }
            buttonPause.setOnClickListener { viewModel.pauseFirstStopwatch() }
            buttonStop.setOnClickListener { viewModel.stopFirstStopwatch() }

            buttonStartSecond.setOnClickListener { viewModel.startSecondStopwatch() }
            buttonPauseSecond.setOnClickListener { viewModel.pauseSecondStopwatch() }
            buttonStopSecond.setOnClickListener { viewModel.stopSecondStopwatch() }
        }
    }

    override fun onDestroy() {
        scope.cancel()
        super.onDestroy()
    }
}