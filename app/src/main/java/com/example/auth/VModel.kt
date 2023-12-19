package com.example.auth

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class VModel: ViewModel() {
    val goOn: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }
}