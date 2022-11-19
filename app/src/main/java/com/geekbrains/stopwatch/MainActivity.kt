package com.geekbrains.stopwatch

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.geekbrains.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textView = binding.message
        ViewModelProvider(this)[MainViewModel::class.java].liveData.observe(
            this
        ) { dataFromDataBase ->
            textView.text = dataFromDataBase.data
        }
    }
}