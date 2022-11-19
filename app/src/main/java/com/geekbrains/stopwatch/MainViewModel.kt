package com.geekbrains.stopwatch

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

internal class MainViewModel(
    repository: Repository = Repository()
): ViewModel() {

    val liveData: LiveData<Data> = repository.userData.asLiveData()

//    val liveData: MutableLiveData<Data> = MutableLiveData()
//
//    init {
//        viewModelScope.launch {
//            repository.userData.flowOn(Dispatchers.Main)
//                .collect { data ->
//                    liveData.value = data
//                }
//        }
//    }
}