package com.intermodular.hotel.presentation.screens.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.intermodular.hotel.domain.LoginCustomerUseCase
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    fun onEmailChange(email: String) {
        _email.postValue(email)
    }

    fun onPasswordChange(password: String) {
        _password.postValue(password)
    }

    fun onLoginPress(navController: NavController) {
        viewModelScope.launch {
            val loginCustomerUseCase = LoginCustomerUseCase()
            val email = _email.value
            val password = _password.value

            if (email.isNullOrBlank() || password.isNullOrBlank()) {
                return@launch
            }

            if (loginCustomerUseCase.login(email, password)) {
                navController.navigate(route = "home")
            }
        }
    }
}