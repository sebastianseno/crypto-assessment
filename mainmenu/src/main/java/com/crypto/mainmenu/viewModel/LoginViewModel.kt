package com.crypto.mainmenu.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.crypto.mainmenu.common.UiState
import com.crypto.mainmenu.utils.Utility
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    val state = MutableLiveData<UiState>()

    fun areRequiredFieldIsValid(
        email: String,
        password: String
    ) {
        val error = when {
            !Utility().isEmailValid(email) -> "Email"
            !Utility().isPasswordValid(password) -> "Password "
            else -> null
        }
        if (error != null) {
            state.postValue(UiState.Error("$error not valid"))
            return
        } else {
            state.postValue(UiState.Success)
        }
    }
}