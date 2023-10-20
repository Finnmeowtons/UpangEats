package com.example.upangeats.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel(){

    val sideNavDrawerSelectedState = MutableLiveData<Int>()

    val currentFragmentTag = MutableLiveData<String>()
}