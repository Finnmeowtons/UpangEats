package com.example.upangeats.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.upangeats.dataclass.Food

class SharedViewModel : ViewModel(){

    val selectedProduct = MutableLiveData<Food>()

    val sideNavDrawerSelectedState = MutableLiveData<Int>()

    val currentFragmentTag = MutableLiveData<String>()
}