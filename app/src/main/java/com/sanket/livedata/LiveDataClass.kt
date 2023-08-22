package com.sanket.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataClass(): ViewModel() {

    var data : MutableLiveData<Int> = MutableLiveData()
}