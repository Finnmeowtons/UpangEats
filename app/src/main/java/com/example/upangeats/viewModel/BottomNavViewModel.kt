package com.example.upangeats.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BottomNavViewModel : ViewModel() {
    val selectedItemId: MutableLiveData<Int> = MutableLiveData()
}