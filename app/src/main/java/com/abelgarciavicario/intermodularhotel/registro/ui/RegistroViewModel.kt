package com.abelgarciavicario.intermodularhotel.registro.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abelgarciavicario.intermodularhotel.login.domain.RegistroUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistroViewModel @Inject constructor(private val registroUseCase: RegistroUseCase) :
    ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    private val _passwordR = MutableLiveData<String>()
    val passwordR: LiveData<String> = _passwordR
    private val _nombre = MutableLiveData<String>()
    val nombre: LiveData<String> = _nombre
    private val _isLogEnable = MutableLiveData<Boolean>()
    val isLogEnable: LiveData<Boolean> = _isLogEnable
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLogEnable
    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun clearErrorMessage() {
        _errorMessage.value = null
    }

    private fun enableLog(nombre: String, email: String, passwordR: String, password: String) =
        password.length > 6 && nombre.length > 1 && email.length > 1 && passwordR.length > 1

    private fun correctPassword(passwordR: LiveData<String>, password: LiveData<String>) =
        password.value == passwordR.value

    private fun correctEmail(email: LiveData<String>) =
        email.value?.contains("@")

    fun onRegistroChange(nombre: String, email: String, password: String, passwordR: String) {
        _nombre.value = nombre
        _email.value = email
        _password.value = password
        _passwordR.value = passwordR
        _isLogEnable.value = enableLog(nombre, email, passwordR, password)

    }


    /* fun onRegistroSelected(navController: NavController){

         viewModelScope.launch {
             _isLoading.value=true
             if (correctPassword(passwordR, password) && correctEmail(email) == true) {
                 val result = registroUseCase(nombre.value!!, email.value!!, password.value!!)
                 if(result){
                     navController.navigate(Destinations.Home.route)
                 }else{
                     _errorMessage.value = "Error en el registro."
                 }
             } else if (!correctPassword(passwordR, password)) {
                 _errorMessage.value = "Error. Las contraseñas deben coincidir"
             } else {
                 _errorMessage.value = "Error. Debe introducir un email válido"
             }
         }
         _isLoading.value=false
     }*/
}