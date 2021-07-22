package com.crypto.mainmenu.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor() : ViewModel() {

    val stringData = MutableLiveData<String>()

    fun getString(string: String) {
        viewModelScope.launch {
            stringData.value = string
        }
    }
}