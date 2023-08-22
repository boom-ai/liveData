package com.sanket.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel:ViewModel() {
    var color : MutableLiveData<Int> = MutableLiveData(1)
    var number : MutableLiveData<Int> = MutableLiveData(1)
}