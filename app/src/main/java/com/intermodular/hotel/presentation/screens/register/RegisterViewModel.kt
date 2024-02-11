package com.intermodular.hotel.presentation.screens.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.intermodular.hotel.domain.RegisterGuestUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerGuestUseCase: RegisterGuestUseCase
) : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _surname = MutableLiveData<String>()
    val surname: LiveData<String> = _surname

    private val _isLogEnabled = MutableLiveData<Boolean>()
    val isLogEnabled: LiveData<Boolean> = _isLogEnabled

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: MutableLiveData<String?> = _errorMessage

    fun clearErrorMessage() {
        _errorMessage.value = null
    }

    private fun enableLog(nombre: String, email: String, passwordR: String, password: String) =
        password.length > 6 && nombre.length > 1 && email.length > 1 && passwordR.length > 1

    private fun comparePassword() {
        val pass = _password.value
        val pass2 = _confirmPassword.value

        if (pass == null || pass2 == null) {
            return
        }
    }

    fun onRegistroChange(nombre: String, email: String, password: String, passwordR: String) {
        _name.value = nombre
        _email.value = email
        _password.value = password
        _confirmPassword.value = passwordR
        _isLogEnabled.value = enableLog(nombre, email, passwordR, password)
    }

    fun onRegisterPress(navController: NavController) {
        val name = _name.value
        val surname = _surname.value
        val email = _email.value
        val password = _password.value

        if (name == null || surname == null || email == null || password == null) {
            return
        }

        viewModelScope.launch {
            val response = registerGuestUseCase.registerGuest(name, surname, email, password)

            if (!response) {
                return@launch
            }

            navController.navigate("home")
        }
    }
}