package com.example.upangeats.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){
    private val _uiState = MutableLiveData<Unit>()
    val uiState: LiveData<Unit> get() = _uiState


    val sideNavDrawerSelectedState = MutableLiveData<Int>()
}