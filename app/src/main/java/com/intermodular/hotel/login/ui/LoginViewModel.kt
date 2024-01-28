package com.intermodular.hotel.login.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.data.model.UserModel
import com.intermodular.hotel.domain.GetUserUseCase
import com.intermodular.hotel.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
) : ViewModel(){
    val userModel = MutableLiveData<User>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getUserUseCase()

            if(!result.isNullOrEmpty()) {
               userModel.postValue(result[0])
               isLoading.postValue(false)
            }


        }

    }
}