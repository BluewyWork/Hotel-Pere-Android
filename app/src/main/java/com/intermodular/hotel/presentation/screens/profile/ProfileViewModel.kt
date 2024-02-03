package com.intermodular.hotel.presentation.screens.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.intermodular.hotel.domain.GetCustomerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getCustomerUseCase: GetCustomerUseCase
) : ViewModel() {
    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _lastname = MutableLiveData<String>()
    val lastname: LiveData<String> = _lastname

    private val _phoneNumber = MutableLiveData<String>()
    val phoneNumber: LiveData<String> = _phoneNumber

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onUsernameChange(username: String) {
        _username.postValue(username)
    }

    fun onLastNameChange(lastName: String) {
        _lastname.postValue(lastName)
    }

    fun onPhoneNumberChange(phoneNumber: String) {
        _phoneNumber.postValue(phoneNumber)
    }

    fun onEmailChange(email: String) {
        _email.postValue(email)
    }

    fun onCreate() {
        viewModelScope.launch {
            val customer = getCustomerUseCase.invoke() ?: return@launch

            _username.postValue(customer.name)
            _lastname.postValue(customer.surname)
            _email.postValue(customer.email)
        }
    }

    fun onUpdatePress() {
       TODO()
    }
}