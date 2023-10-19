package com.example.upangeats.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LogInActivityToMainActivityViewModel : ViewModel(){
    val buttonClicked: MutableLiveData<Boolean> = MutableLiveData()
}