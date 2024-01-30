package com.intermodular.hotel.login.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.data.model.UserModel
import com.intermodular.hotel.domain.GetUserUseCase
import com.intermodular.hotel.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel : ViewModel(){
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value = password
    }

    fun onLoginPress() {
        println(email)
        println(password)
    }
}