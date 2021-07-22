package com.crypto.mainmenu.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crypto.mainmenu.common.UiState
import com.crypto.mainmenu.network.entity.Data
import com.crypto.mainmenu.network.services.CryptoCompareService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WatchListViewModel @Inject constructor(
    private val service: CryptoCompareService
) : ViewModel() {

    val cryptoData = MutableLiveData<List<Data>>()

    val state  = MutableLiveData<UiState>()

    fun refreshTotalTopTier(isRefreshing:Boolean,page: Int, limit: Int, tsym: String) {
        viewModelScope.launch {
            if (isRefreshing) state.postValue(UiState.Refreshing) else
                state.postValue(UiState.Loading)
            runCatching {
                service.getTotalTopTier(page, limit, tsym)
            }.onSuccess {
                cryptoData.value = it.data
                state.postValue(UiState.Success)
            }.onFailure {
                state.postValue(UiState.Error(it.message?:"Something went wrong"))
            }
        }
    }
}